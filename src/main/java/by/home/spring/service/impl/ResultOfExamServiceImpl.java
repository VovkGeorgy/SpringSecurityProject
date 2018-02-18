package by.home.spring.service.impl;

import by.home.spring.entity.ExamEntity;
import by.home.spring.entity.ResultOfExamEntity;
import by.home.spring.repository.ResultOfExamEntityRepository;
import by.home.spring.service.ResultOfExamServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ResultOfExamServiceImpl implements ResultOfExamServise {

    @Autowired
    ResultOfExamEntityRepository repository;

    @Override
    public ResultOfExamEntity addResultOfExam(ResultOfExamEntity resultOfExam) {
        return repository.saveAndFlush(resultOfExam);
    }

    @Override
    public ResultOfExamEntity getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public int updateResultOfCurrentExam(boolean passing, Integer pk) {
        return repository.updateResultOfCurrentExam(passing, pk);
    }

    public ResultOfExamEntity deleteByPassing(Boolean passing){
        return repository.deleteByPassing(passing);
    }

    @Override
    public List<ResultOfExamEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ResultOfExamEntity findOne(Integer id) {
        return repository.findOne(id);
    }
}
