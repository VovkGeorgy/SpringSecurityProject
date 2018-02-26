package by.home.spring.service;

import by.home.spring.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {

    /**
     * This method find and return all entities of Teacher type
     *
     * @return List<TeacherEntity>
     */
    List<TeacherEntity> findAll();

    /**
     * Saves TeacherEntity and flushes changes instantly.
     *
     * @param teacher - saved teacher
     * @return TeacherEntity
     */
    TeacherEntity saveAndFlush(TeacherEntity teacher);

    /**
     * This method get one TeacherEntity where column Id = TeacherEntity Id
     *
     * @param id - Teacher Id
     * @return TeacherEntity
     */
    TeacherEntity getOne(Integer id);

    /**
     * This method update teacher car field at TeacherEntity where teacher fio = fio
     *
     * @param car - new car Id
     * @param teacherFio      - current Teacher fio
     * @return int - count of changed rows
     */
    int updateTeacherEntityCar(int car, String teacherFio);

    /**
     * This method delete Teacher Entity
     *
     * @param teacherId - Student entity
     * @return TeacherEntity
     */
    TeacherEntity deleteByTeacherId(Integer teacherId);
}
