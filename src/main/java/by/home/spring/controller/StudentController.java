package by.home.spring.controller;

import by.home.spring.entity.StudentEntity;
import by.home.spring.service.StudentService;
import by.home.spring.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getStudentEntity(String fio, int workGroup, int yearsOld, int teacherId) {
        StudentEntity stud = new StudentEntity();
        logger.debug("Create new object StudentEntity", stud);
        stud.setFio(fio);
        stud.setWorkGroup(workGroup);
        try {
            if (yearsOld < 18) throw new Exception();
        } catch (Exception e) {
            logger.error("ERROR not right years old!", e);
        }
        stud.setYearsOld(yearsOld);
        stud.setTeacher(teacherService.getOne(teacherId));
        studentService.saveAndFlush(stud);
        logger.debug("Object successfully saved", stud);
        return "student added" + stud;
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<StudentEntity> getStudentsNames(ModelMap model) {
        return studentService.findAll();
    }

    @RequestMapping(value = "/getNames", method = RequestMethod.GET)
    public String getNames(ModelMap model) {
        Locale ruLocale = new Locale("ru", "RU");
        Locale.setDefault(ruLocale);
        return messageSource.getMessage("customer.name", new Object[]{"25"}, Locale.getDefault());
    }

    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateSudentEntity(int yearsOld, String fio, ModelMap model) {
        studentService.updateStudentEntityYearsOld(yearsOld, fio);
        return "Student yearsOld are updated!";
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteStudentEntity(int studId) {
        return "Entity - " + studentService.deleteByStudentId(studId) + "was deleted";

    }
}
