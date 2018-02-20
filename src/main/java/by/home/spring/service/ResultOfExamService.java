package by.home.spring.service;

import by.home.spring.entity.ExamEntity;
import by.home.spring.entity.ResultOfExamEntity;

import java.util.List;

public interface ResultOfExamService {

    ResultOfExamEntity saveAndFlush(ResultOfExamEntity resultOfExam);

    ResultOfExamEntity getOne(Integer id);

    int updateResultOfCurrentExam(boolean passing, Integer pk);

    ResultOfExamEntity deleteByPassing(Boolean passing);

    List<ResultOfExamEntity> findAll();

    ResultOfExamEntity findOne(Integer id);
}
