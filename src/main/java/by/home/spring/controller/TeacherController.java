package by.home.spring.controller;

import by.home.spring.entity.TeacherEntity;
import by.home.spring.service.CarService;
import by.home.spring.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    CarService carService;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    /**
     * Method add Teacher entity with @params
     * @param fio - fio
     * @param experience - driving experience
     * @param studentsNumber - number of studding students
     * @param carId - car ID
     * @return - message
     */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getCarEntity(String fio, int experience, int studentsNumber, int carId) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setFio(fio);
        teacher.setExperience(experience);
        teacher.setStudentsNumber(studentsNumber);
        teacher.setCar(carService.getOne(carId));
        teacherService.saveAndFlush(teacher);
        logger.info(messageSource.getMessage("object.create.ok", new Object[]{teacher}, Locale.getDefault()));
        return messageSource.getMessage("object.create.ok", new Object[]{teacher}, Locale.getDefault());
    }

    /**
     * Method select Teacher entity by the input fio, and update them car ID
     * @param carId - car ID
     * @param fio - fio
     * @param model - model
     * @return - message
     */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateTeacherEntity(int carId, String fio, ModelMap model) {
        teacherService.updateTeacherEntityCar(carId, fio);
        logger.info(messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault()));
        return messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault());
    }

    /**
     * Method delete Teacher Entity by TeacherId
     * @param teacherId - id of the Teacher we wanted to remove
     * @return - message and deleted Teacher Entity
     */
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteTeacherEntity(int teacherId) {
        return "Entity - " + teacherService.deleteByTeacherId(teacherId) + "was deleted";

    }

    /**
     * Method return all Teacher entity from dataBase to view page at JSON format
     * @param model - model
     * @return List<TeacherEntity>
     */
    @RequestMapping(value = "/getAllEntities", method = RequestMethod.GET)
    public List<TeacherEntity> getAllTeachers(ModelMap model) {
        return teacherService.findAll();
    }
}
