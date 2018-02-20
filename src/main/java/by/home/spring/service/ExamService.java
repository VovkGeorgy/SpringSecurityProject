package by.home.spring.service;

import by.home.spring.entity.ExamEntity;

import java.util.List;

public interface ExamService {
    ExamEntity saveAndFlush(ExamEntity exam);

    ExamEntity getOne(Integer eId);

    int updateExamEntityTichetNumber(int ticketNumber, String examType);

    ExamEntity deleteExamEntityByExamId(Integer id);

    List<ExamEntity> findAll();

    Long getExamCount();

    ExamEntity findByExamId(Integer id);

}


