package by.home.spring.repository;

import by.home.spring.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherEntityRepository extends JpaRepository<TeacherEntity, Integer> {

    /**
     * Saves TeacherEntity and flushes changes instantly.
     *
     * @param teacher - saved teacher
     * @return TeacherEntity
     */
    @Override
    TeacherEntity saveAndFlush(TeacherEntity teacher);

    /**
     * This method get one TeacherEntity where column Id = TeacherEntity Id
     *
     * @param id - Teacher Id
     * @return TeacherEntity
     */
    @Override
    TeacherEntity getOne(Integer id);

    /**
     * This method update teacher car field at TeacherEntity where teacher fio = fio
     *
     * @param car - new car Id
     * @param teacherFio      - current Teacher fio
     * @return int - count of changed rows
     */
    @Query(value = "update TeacherEntity teacher set teacher.car= ?1 where teacher.fio= ?2")
    int updateTeacherEntityCar(int car, String teacherFio);

    /**
     * This method delete Teacher Entity
     *
     * @param teacherId - Student entity
     * @return TeacherEntity
     */
    @Transactional
    TeacherEntity deleteByTeacherId(Integer teacherId);
}
