package by.home.spring.service.impl;

import by.home.spring.entity.ResultOfExamEntity;
import by.home.spring.repository.ResultOfExamEntityRepository;
import by.home.spring.service.ResultOfExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ResultOfExamServiceImpl implements ResultOfExamService {

    @Autowired
    ResultOfExamEntityRepository repository;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(ResultOfExamServiceImpl.class);

    /**
     * Saves ResultOfExamEntity and flushes changes instantly.
     *
     * @param resultOfExam - saved result Of Exam
     * @return ResultOfExamEntity
     */
    @Override
    public ResultOfExamEntity saveAndFlush(ResultOfExamEntity resultOfExam) {
        logger.info(messageSource.getMessage("object.creating", new Object[]{null}, Locale.getDefault()));
        return repository.saveAndFlush(resultOfExam);
    }

    /**
     * This method get one resultOfExam where column Id = resultOfExam Id
     *
     * @param id - result Of Exam Id
     * @return ResultOfExamEntity
     */
    @Override
    public ResultOfExamEntity getOne(Integer id) {
        logger.info(messageSource.getMessage("object.receiving", new Object[]{null}, Locale.getDefault()));
        return repository.getOne(id);
    }

    /**
     * This method update passing field at ExamEntity where pk = pk
     *
     * @param passing - result of exam (passing)
     * @param pk        - current ResultOfExamEntity pk
     * @return int - count of changed rows
     */
    @Override
    public int updateResultOfCurrentExam(boolean passing, Integer pk) {
        logger.info(messageSource.getMessage("object.field.updating", new Object[]{null}, Locale.getDefault()));
        return repository.updateResultOfCurrentExam(passing, pk);
    }

    /**
     * This method delete ResultOfExamEntity by exam passing value
     *
     * @param passing - true or false value by exam passing
     * @return ResultOfExamEntity
     */
    public ResultOfExamEntity deleteByPassing(Boolean passing){
        logger.info(messageSource.getMessage("object.deleting", new Object[]{null}, Locale.getDefault()));
        return repository.deleteByPassing(passing);
    }

    /**
     * This method find and return all entities of ResultOfExam type
     *
     * @return List<ResultOfExamEntity>
     */
    @Override
    public List<ResultOfExamEntity> findAll() {
        logger.info(messageSource.getMessage("object.findingAll", new Object[]{null}, Locale.getDefault()));
        return repository.findAll();
    }

    /**
     * This method find and return entity of ResultOfExam type with ResultOfExamId = id
     *
     * @param id - ResultOfExam id
     * @return ResultOfExamEntity
     */
    @Override
    public ResultOfExamEntity findOne(Integer id) {
        logger.info(messageSource.getMessage("object.finding", new Object[]{null}, Locale.getDefault()));
        return repository.findOne(id);
    }
}
