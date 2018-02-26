package by.home.spring.service;

import by.home.spring.entity.ResultOfExamEntity;

import java.util.List;

public interface ResultOfExamService {

    /**
     * Saves ResultOfExamEntity and flushes changes instantly.
     *
     * @param resultOfExam - saved result Of Exam
     * @return ResultOfExamEntity
     */
    ResultOfExamEntity saveAndFlush(ResultOfExamEntity resultOfExam);

    /**
     * This method get one resultOfExam where column Id = resultOfExam Id
     *
     * @param id - result Of Exam Id
     * @return ResultOfExamEntity
     */
    ResultOfExamEntity getOne(Integer id);

    /**
     * This method update passing field at ExamEntity where pk = pk
     *
     * @param passing - result of exam (passing)
     * @param pk        - current ResultOfExamEntity pk
     * @return int - count of changed rows
     */
    int updateResultOfCurrentExam(boolean passing, Integer pk);

    /**
     * This method delete ResultOfExamEntity by exam passing value
     *
     * @param passing - true or false value by exam passing
     * @return ResultOfExamEntity
     */
    ResultOfExamEntity deleteByPassing(Boolean passing);

    /**
     * This method find and return all entities of ResultOfExam type
     *
     * @return List<ResultOfExamEntity>
     */
    List<ResultOfExamEntity> findAll();

    /**
     * This method find and return entity of ResultOfExam type with ResultOfExamId = id
     *
     * @param id - ResultOfExam id
     * @return ResultOfExamEntity
     */
    ResultOfExamEntity findOne(Integer id);
}
