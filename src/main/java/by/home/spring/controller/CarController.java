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

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getCarEntity(String mark, String regNumber, int mileage, int teacherId) {
        logger.debug(messageSource.getMessage("object.creating", new Object[]{null}, Locale.getDefault()));
        CarEntity car = new CarEntity();
        logger.debug(messageSource.getMessage("object.create", new Object[]{car}, Locale.getDefault()));
        car.setMark(mark);
        car.setRegNumber(regNumber);
        car.setMileage(mileage);
        try {
            if (teacherService.getOne(teacherId) == null) throw new Exception();
        } catch (Exception e) {
            logger.error(messageSource.getMessage("field.set.error", new Object[]{e}, Locale.getDefault()), e);
        }
        car.setTeacher(teacherService.getOne(teacherId));
        carService.saveAndFlush(car);
        logger.debug(messageSource.getMessage("object.save.successful", new Object[]{car}, Locale.getDefault()), car);
        return "Car successfully added" + car;
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public List<CarEntity> getAllCars(ModelMap model) {
        logger.debug(messageSource.getMessage("object.getAll", new Object[]{null}, Locale.getDefault()));
        return carService.findAll();
    }

    /**
     * Set the locale configuration with a param 'locale'
     *
     * @param language - language, what we needed
     * @param location - location, where you are
     * @return message from locale settings
     */
    @RequestMapping(value = "/setLocale", method = RequestMethod.GET)
    public String setLocale(String language, String location, ModelMap model) {
        Locale defLocale = new Locale(language, location);
        Locale.setDefault(defLocale);
        return messageSource.getMessage("locale.changed", new Object[]{null}, Locale.getDefault());
    }

    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateCarEntity(int milleage, String regNumber, ModelMap model) {
        carService.updateCarEntityMileage(milleage, regNumber);
        return "Car milleage are updated!";
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteCarEntity(int carId) {
        return "Entity - " + carService.deleteCarEntityByCarId(carId) + "was deleted";

    }
}
