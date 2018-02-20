package by.home.spring.service.impl;

import by.home.spring.entity.ExamEntity;
import by.home.spring.repository.ExamEntityRepository;
import by.home.spring.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamEntityRepository repository;

    public ExamEntity saveAndFlush(ExamEntity exam) {
        return repository.saveAndFlush(exam);
    }

    @Override
    public ExamEntity getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public int updateExamEntityTichetNumber(int ticketNumber, String examType) {
        return repository.updateExamEntityTichetNumber(ticketNumber, examType);
    }

    @Override
    public ExamEntity findByExamId(Integer examId) {
        return repository.findByExamId(examId);
    }

    @Override
    public List<ExamEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ExamEntity deleteExamEntityByExamId(Integer examId) {
        return repository.deleteExamEntityByExamId(examId);
    }

    public Long getExamCount() {
        return repository.count();
    }
}