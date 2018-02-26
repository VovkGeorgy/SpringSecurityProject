package by.home.spring.service.impl;

import by.home.spring.entity.CarEntity;
import by.home.spring.repository.CarEntityRepository;
import by.home.spring.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarEntityRepository repository;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    /**
     * Saves CarEntity and flushes changes instantly.
     *
     * @param car - saved car
     * @return CarEntity
     */
    public CarEntity saveAndFlush(CarEntity car) {
        logger.info(messageSource.getMessage("object.creating", new Object[]{null}, Locale.getDefault()));
        return repository.saveAndFlush(car);
    }

    /**
     * This method returns Cars where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    @Override
    public CarEntity findByCarId(Integer id) {
        logger.info(messageSource.getMessage("object.finding", new Object[]{null}, Locale.getDefault()));
        return repository.findByCarId(id);
    }

    /**
     * This method update milleage at Car where column reg_number = regNumber
     *
     * @param mileage - new car milleage, regNumber - current Car regNumber
     * @return int - count of changed rows
     */
    public int updateCarEntityMileage(int mileage, String regNumber){
        logger.info(messageSource.getMessage("object.field.updating", new Object[]{null}, Locale.getDefault()));
        return repository.updateCarEntityMileage(mileage, regNumber);
    }

    /**
     * This method delete Car where column Id = carId
     *
     * @param carId - car Id
     * @return CarEntity
     */
    @Override
    public CarEntity deleteCarEntityByCarId(Integer carId) {
        logger.info(messageSource.getMessage("object.deleting", new Object[]{null}, Locale.getDefault()));
        return repository.deleteCarEntityByCarId(carId);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    public Long getCarCount(){
        logger.info(messageSource.getMessage("object.counting", new Object[]{null}, Locale.getDefault()));
        return repository.count();
    }

    /**
     * This override method of CRUD-repository get one Car where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    @Override
    public CarEntity getOne(Integer id) {
        logger.info(messageSource.getMessage("object.receiving", new Object[]{null}, Locale.getDefault()));
        return repository.getOne(id);
    }

    /**
     * This override method of JPA-repository find one Car where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    @Override
    public CarEntity findOne(Integer id) {
        logger.info(messageSource.getMessage("object.finding", new Object[]{null}, Locale.getDefault()));
        return repository.findOne(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return List<CarEntity>
     */
    @Override
    public List<CarEntity> findAll() {
        logger.info(messageSource.getMessage("object.findingAll", new Object[]{null}, Locale.getDefault()));
        return repository.findAll();
    }
}