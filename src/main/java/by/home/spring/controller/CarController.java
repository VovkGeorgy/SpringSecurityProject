package by.home.spring.controller;

import by.home.spring.entity.CarEntity;
import by.home.spring.service.CarService;
import by.home.spring.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    /**
     * Method add Car entity with @params
     * @param mark - car mark
     * @param regNumber - car registration Number
     * @param mileage - car mileage
     * @param teacherId - teacher who driving the car
     * @return - message "Car added"
     */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getCarEntity(String mark, String regNumber, int mileage, int teacherId) {
        CarEntity car = new CarEntity();
        car.setMark(mark);
        car.setRegNumber(regNumber);
        car.setMileage(mileage);
        try {
            if (teacherService.getOne(teacherId) == null) throw new Exception();
        } catch (Exception e) {
            logger.error(messageSource.getMessage("object.field.updating.error", new Object[]{car}, Locale.getDefault()), e);
        }
        car.setTeacher(teacherService.getOne(teacherId));
        logger.info(messageSource.getMessage("object.create.ok", new Object[]{car}, Locale.getDefault()));
        carService.saveAndFlush(car);
        return messageSource.getMessage("object.create.ok", new Object[]{car}, Locale.getDefault());
    }

    /**
     * Method return all cars entity from dataBase to view page at JSON format
     * @param model - model
     * @return - array with all car Entity
     */
    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public List<CarEntity> getAllCars(ModelMap model) {
        return carService.findAll();
    }

    /**
     * Method select car entity by the input register number, and update it mileage
     * @param milleage - new mileage
     * @param regNumber - register number with car we wanted
     * @param model - model
     * @return - message "car mileage are updated"
     */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateCarEntity(int milleage, String regNumber, ModelMap model) {
        carService.updateCarEntityMileage(milleage, regNumber);
        logger.info(messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault()));
        return messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault());
    }

    /**
     * Method delete Car Entity by carId
     * @param carId - id of the car we wanted to remove
     * @return - message and deleted Car Entity
     */
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteCarEntity(int carId) {
        return "Entity - " + carService.deleteCarEntityByCarId(carId) + "was deleted";

    }
}
