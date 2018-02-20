package by.home.spring.controller;

import by.home.spring.entity.CarEntity;
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
    public String getCarEntity(String mark, String regNumber, int milleage, int teacherId) {
        CarEntity car = new CarEntity();
        logger.debug("Create new object CarEntity", car);
        car.setMark(mark);
        car.setRegNumber(regNumber);
        car.setMileage(milleage);
        try {
            if (teacherService.getOne(teacherId) == null) throw new Exception();
        } catch (Exception e) {
            logger.error("ERROR teacher by " + teacherId + " is not found! ", e);
        }
        car.setTeacher(teacherService.getOne(teacherId));
        carService.saveAndFlush(car);
        logger.debug("Object successfully saved", car);
        return "Car successfully added" + car;
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public List<CarEntity> getAllCars(ModelMap model) {
        return carService.findAll();
    }

    @RequestMapping(value = "/getNames", method = RequestMethod.GET)
    public String getNames(ModelMap model) {
        Locale ruLocale = new Locale("ru", "RU");
        Locale.setDefault(ruLocale);
        return messageSource.getMessage("customer.name", new Object[]{"25"}, Locale.getDefault());
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
