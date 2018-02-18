package by.home.spring.repository;

import by.home.spring.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExamEntityRepository extends JpaRepository<ExamEntity, Integer> {

    /**
     * Saves ExamEntity and flushes changes instantly.
     *
     * @param exam - saved exam
     * @return ExamEntity
     */
    @Override
    ExamEntity saveAndFlush(ExamEntity exam);

    /**
     * This method get one Exam where column Id = examId
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    @Override
    ExamEntity getOne(Integer examId);

    /**
     * This method update ticketNumber at ExamEntity where column exam_Type = examType
     *
     * @param ticketNumber - new exam ticket Number, examType - current exam type
     * @return int - count of changed rows
     */
    @Query(value = "update ExamEntity exam set exam.ticketNumber = ?1 where exam.examType= ?2")
    int updateExamEntityTichetNumber(int ticketNumber, String examType);

    /**
     * This method delete Exam where column examId = exam Id
     *
     * @param examId
     *            - exam Id
     * @return ExamEntity
     */
    @Transactional
    ExamEntity deleteExamEntityByExamId(Integer examId);

    /**
     * This method returns Exam where column examId = exam Id
     *
     * @param examId
     *            - exam Id
     * @return ExamEntity
     */
    ExamEntity findByExamId(Integer examId);

    /**
     * This method returns Exam where column exam_type = examType
     *
     * @param examType
     *            - exam type
     * @return ExamEntity
     */
    @Query(value = "SELECT * FROM exam WHERE exam_type=?1", nativeQuery = true)
    ExamEntity findByType(String examType);
}
