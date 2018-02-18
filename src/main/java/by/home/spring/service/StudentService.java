package by.home.spring.service;

import by.home.spring.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentEntity saveAndFlush(StudentEntity student);

    StudentEntity getOne(Integer id);

    int updateStudentEntityYearsOld(int studentYearsOld, String studentFio);

    void deleteByStudentId(Integer Id);

    List<StudentEntity> findAll();
}
