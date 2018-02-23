package by.home.spring.service;

import by.home.spring.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {

    List<TeacherEntity> findAll();

    TeacherEntity saveAndFlush(TeacherEntity teacher);

    TeacherEntity getOne(Integer id);

    int updateTeacherEntityCar(int car, String teacherFio);

    TeacherEntity deleteByTeacherId(Integer id);
}
