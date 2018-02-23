package by.home.spring.controller;

import by.home.spring.entity.TeacherEntity;
import by.home.spring.service.CarService;
import by.home.spring.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getCarEntity(String fio, int experience, int studentsNumber, int carId) {
        TeacherEntity teacher = new TeacherEntity();
        logger.debug("Create new object TeacherEntity", teacher);
        teacher.setFio(fio);
        teacher.setExperience(experience);
        teacher.setStudentsNumber(studentsNumber);
        teacher.setCar(carService.getOne(carId));
        teacherService.saveAndFlush(teacher);
        logger.debug("Object successfully saved", teacher);
        return "Teacher successfully added" + teacher;
    }

    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateTeacherEntity(int teacherId, String fio, ModelMap model) {
        teacherService.updateTeacherEntityCar(teacherId, fio);
        return "Teachers car are updated!";
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteTeacherEntity(int teacherId) {
        return "Entity - " + teacherService.deleteByTeacherId(teacherId) + "was deleted";

    }

    @RequestMapping(value = "/getAllTeachers", method = RequestMethod.GET)
    public List<TeacherEntity> getTeacher(ModelMap model) {
        return teacherService.findAll();
    }
}
