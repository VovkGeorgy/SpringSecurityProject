package by.home.spring.service.impl;

import by.home.spring.controller.CarController;
import by.home.spring.entity.ExamEntity;
import by.home.spring.repository.ExamEntityRepository;
import by.home.spring.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamEntityRepository repository;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(ExamServiceImpl.class);

    /**
     * Saves an entity and flushes changes instantly.
     *
     * @param exam - ExamEntity
     * @return the saved entity
     */
    public ExamEntity saveAndFlush(ExamEntity exam) {
        logger.info(messageSource.getMessage("object.creating", new Object[]{null}, Locale.getDefault()));
        return repository.saveAndFlush(exam);
    }

    /**
     * This method get one Exam where column Id = examId
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    @Override
    public ExamEntity getOne(Integer examId) {
        logger.info(messageSource.getMessage("object.receiving", new Object[]{null}, Locale.getDefault()));
        return repository.getOne(examId);
    }

    /**
     * This method update ticketNumber at ExamEntity where column exam_Type = examType
     *
     * @param ticketNumber - new exam ticket Number,
     * @param examType     - current exam type
     * @return int - count of changed rows
     */
    @Override
    public int updateExamEntityTichetNumber(int ticketNumber, String examType) {
        logger.info(messageSource.getMessage("object.field.updating", new Object[]{null}, Locale.getDefault()));
        return repository.updateExamEntityTichetNumber(ticketNumber, examType);
    }

    /**
     * This method returns Exam where column examId = exam Id
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    @Override
    public ExamEntity findByExamId(Integer examId) {
        logger.info(messageSource.getMessage("object.finding", new Object[]{null}, Locale.getDefault()));
        return repository.findByExamId(examId);
    }

    /**
     * Returns all instances of the type.
     *
     * @return List<CarEntity>
     */
    @Override
    public List<ExamEntity> findAll() {
        logger.info(messageSource.getMessage("object.findingAll", new Object[]{null}, Locale.getDefault()));
        return repository.findAll();
    }

    /**
     * This method delete Exam where column examId = exam Id
     *
     * @param examId - exam Id
     * @return ExamEntity
     */
    @Override
    public ExamEntity deleteExamEntityByExamId(Integer examId) {
        logger.info(messageSource.getMessage("object.deleting", new Object[]{null}, Locale.getDefault()));
        return repository.deleteExamEntityByExamId(examId);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    public Long getExamCount() {
        logger.info(messageSource.getMessage("object.counting", new Object[]{null}, Locale.getDefault()));
        return repository.count();
    }
}