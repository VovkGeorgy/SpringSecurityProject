package by.home.spring.service;

import by.home.spring.entity.CarEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CarService {
    CarEntity saveAndFlush(CarEntity car);

    CarEntity getOne(Integer id);

    int updateCarEntityMileage(int mileage, String regNumber);

    CarEntity deleteCarEntityByCarId(Integer carId);

    CarEntity findByCarId(Integer id);

    Long getCarCount();

    CarEntity findOne(Integer id);

    List<CarEntity> findAll();

}


