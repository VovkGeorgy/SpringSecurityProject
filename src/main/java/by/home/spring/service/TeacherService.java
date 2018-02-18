package by.home.spring.service;

import by.home.spring.entity.TeacherEntity;

public interface TeacherService {

    TeacherEntity saveAndFlush(TeacherEntity teacher);

    TeacherEntity getOne(Integer id);

    int updateTeacherEntityCar(int car, String teacherFio);

    TeacherEntity deleteByTeacherId(Integer id);
}
