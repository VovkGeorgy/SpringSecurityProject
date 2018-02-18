package by.home.spring.service.impl;

import by.home.spring.entity.TeacherEntity;
import by.home.spring.repository.TeacherEntityRepository;
import by.home.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiseImpl implements TeacherService {

    @Autowired
    TeacherEntityRepository repository;

    @Override
    public TeacherEntity saveAndFlush(TeacherEntity teacher) {
        return repository.saveAndFlush(teacher);
    }

    @Override
    public TeacherEntity getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public int updateTeacherEntityCar(int car, String teacherFio) {
        return repository.updateTeacherEntityCar(car, teacherFio);
    }

    @Override
    public TeacherEntity deleteByTeacherId(Integer id) {
        return repository.deleteByTeacherId(id);
    }
}
