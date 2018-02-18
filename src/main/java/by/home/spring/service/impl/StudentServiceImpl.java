package by.home.spring.service.impl;

import by.home.spring.controller.StudentController;
import by.home.spring.entity.StudentEntity;
import by.home.spring.repository.StudentEntityRepository;
import by.home.spring.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentEntityRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Override
    public StudentEntity saveAndFlush(StudentEntity student) {
        logger.debug("Try to save student object!");
        return repository.saveAndFlush(student);
    }

    @Override
    public StudentEntity getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public int updateStudentEntityYearsOld(int studentYearsOld, String studentFio) {
        return repository.updateStudentEntityYearsOld(studentYearsOld, studentFio);
    }

    @Override
    public void deleteByStudentId(Integer id) {
        repository.deleteByStudentId(id);
    }

    @Override
    public List<StudentEntity> findAll() {
        logger.debug("Try to get ALL students object!");
        return repository.findAll();
    }
}
