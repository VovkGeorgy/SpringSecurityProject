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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin
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

    /**
     * Method add Student entity with @params
     * @param fio - student fio
     * @param workGroup - student working group
     * @param yearsOld - student age
     * @param teacherId - student teacher
     * @return - message
     */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getStudentEntity(String fio, int workGroup, int yearsOld, int teacherId) {
        StudentEntity stud = new StudentEntity();
        stud.setFio(fio);
        stud.setWorkGroup(workGroup);
        try {
            if (yearsOld < 18) throw new Exception();
        } catch (Exception e) {
            logger.error(messageSource.getMessage("object.field.updating.error", new Object[]{stud}, Locale.getDefault()), e);
        }
        stud.setYearsOld(yearsOld);
        stud.setTeacher(teacherService.getOne(teacherId));
        studentService.saveAndFlush(stud);
        logger.info(messageSource.getMessage("object.create.ok", new Object[]{stud}, Locale.getDefault()));
        return messageSource.getMessage("object.create.ok", new Object[]{stud}, Locale.getDefault());
    }

    /**
     * Method return all students entity from dataBase to view page at JSON format
     * @param model - model
     * @return List<StudentEntity>
     */
    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<StudentEntity> getStudentsNames(ModelMap model) {
        return studentService.findAll();
    }

    /**
     * Method select students entity by the input fio, and update them age
     * @param yearsOld - students age
     * @param fio - fio
     * @param model - model
     * @return - message
     */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateSudentEntity(int yearsOld, String fio, ModelMap model) {
        studentService.updateStudentEntityYearsOld(yearsOld, fio);
        logger.info(messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault()));
        return messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault());
    }

    /**
     * Method delete student Entity by student ID
     * @param studId - student id
     * @return - message
     */
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteStudentEntity(int studId) {
        return "Entity - " + studentService.deleteByStudentId(studId) + "was deleted";

    }
}
