package by.home.spring.repository;

import by.home.spring.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {

    /**
     * Saves CarEntity and flushes changes instantly.
     *
     * @param car - saved car
     * @return CarEntity
     */
    @Override
    CarEntity saveAndFlush(CarEntity car);

    /**
     * This override method of JPA-repository find one Car where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    @Override
    CarEntity findOne(Integer id);

    /**
     * This method update milleage at Car where column reg_number = regNumber
     *
     * @param mileage - new car milleage, regNumber - current Car regNumber
     * @return int - count of changed rows
     */
    @Query(value = "update CarEntity car set car.mileage = ?1  where car.regNumber = ?2")
    int updateCarEntityMileage(int mileage, String regNumber);

    /**
     * This method delete Car where column Id = carId
     *
     * @param carId - car Id
     * @return CarEntity
     */
    @Transactional
    CarEntity deleteCarEntityByCarId(Integer carId);

    /**
     * This method returns Car where column mark = mark
     *
     * @param mark - car mark
     * @return CarEntity
     */
    @Query(value = "SELECT * FROM car WHERE mark=?1", nativeQuery = true)
    CarEntity findByMark(String mark);

    /**
     * This method returns Cars where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    CarEntity findByCarId(Integer id);

    /**
     * This override method of CRUD-repository get one Car where column Id = id
     *
     * @param id - car Id
     * @return CarEntity
     */
    @Override
    CarEntity getOne(Integer id);
}
