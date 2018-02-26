package by.home.spring.service;

import by.home.spring.entity.ExamEntity;

import java.util.List;

public interface ExamService {

    /**
     * Saves an entity and flushes changes instantly.
     *
     * @param exam - ExamEntity
     * @return the saved entity
     */
    ExamEntity saveAndFlush(ExamEntity exam);

    /**
     * This method get one Exam where column Id = examId
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    ExamEntity getOne(Integer examId);

    /**
     * This method update ticketNumber at ExamEntity where column exam_Type = examType
     *
     * @param ticketNumber - new exam ticket Number,
     * @param examType     - current exam type
     * @return int - count of changed rows
     */
    int updateExamEntityTichetNumber(int ticketNumber, String examType);

    /**
     * This method delete Exam where column examId = exam Id
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    ExamEntity deleteExamEntityByExamId(Integer examId);

    /**
     * Returns all instances of the type.
     *
     * @return List<CarEntity>
     */
    List<ExamEntity> findAll();

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    Long getExamCount();

    /**
     * This method returns Exam where column examId = exam Id
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    ExamEntity findByExamId(Integer examId);

}


