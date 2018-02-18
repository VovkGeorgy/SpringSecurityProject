package by.home.spring.service.impl;

import by.home.spring.entity.CarEntity;
import by.home.spring.repository.CarEntityRepository;
import by.home.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarEntityRepository repository;

    public CarEntity addCar(CarEntity car) {
        return repository.saveAndFlush(car);
    }

    @Override
    public CarEntity findByCarId(Integer id) {
        return repository.findByCarId(id);
    }

    public int updateCarEntityMileage(int mileage, String regNumber){
        return repository.updateCarEntityMileage(mileage, regNumber);
    }

    @Override
    public CarEntity deleteCarEntityByCarId(Integer carId) {
        return repository.deleteCarEntityByCarId(carId);
    }

    public Long getCarCount(){
        return repository.count();
    }

    @Override
    public CarEntity getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public CarEntity findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }
}