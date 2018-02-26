package by.home.spring.service;

import by.home.spring.entity.CarEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CarService {

    /**
     * Saves CarEntity and flushes changes instantly.
     *
     * @param car - saved car
     * @return CarEntity
     */
    CarEntity saveAndFlush(CarEntity car);

    /**
     * This override method of CRUD-repository get one Car where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    CarEntity getOne(Integer id);

    /**
     * This method update milleage at Car where column reg_number = regNumber
     *
     * @param mileage - new car milleage, regNumber - current Car regNumber
     * @return int - count of changed rows
     */
    int updateCarEntityMileage(int mileage, String regNumber);


    /**
     * This method delete Car where column Id = carId
     *
     * @param carId - car Id
     * @return CarEntity
     */
    CarEntity deleteCarEntityByCarId(Integer carId);

    /**
     * This method returns Cars where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    CarEntity findByCarId(Integer id);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    Long getCarCount();

    /**
     * This override method of JPA-repository find one Car where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    CarEntity findOne(Integer id);

    /**
     * Returns all instances of the type.
     *
     * @return List<CarEntity>
     */
    List<CarEntity> findAll();

}


