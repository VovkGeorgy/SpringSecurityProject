package by.home.spring;

import by.home.spring.config.AppConfig;
import by.home.spring.entity.CarEntity;
import by.home.spring.service.CarService;
import by.home.spring.service.impl.CarServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(final String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CarService service = context.getBean(CarServiceImpl.class);

        CarEntity car1 = new CarEntity();
        car1.setMark("zazaza");
        car1.setRegNumber("JH-272-2");
        car1.setMileage(12121212);

        System.out.println(service.addCar(car1) != null ? "done! Car added" : "error...");

        CarEntity car2 = new CarEntity();
        car2.setMark("UAZ");
        car2.setRegNumber("2523-KH-3");
        car2.setMileage(91);

        System.out.println(service.addCar(car2) != null ? "done! Car added" : "error...");

        car2 = service.findByCarId(9);

        System.out.println(car2.getMark() + car2.getRegNumber() + car2.getMileage());
        context.close();

    }
}