package by.home.spring.service.impl;

import by.home.spring.entity.TeacherEntity;
import by.home.spring.repository.TeacherEntityRepository;
import by.home.spring.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherEntityRepository repository;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    /**
     * This method find and return all entities of Teacher type
     *
     * @return List<TeacherEntity>
     */
    @Override
    public List<TeacherEntity> findAll() {
        logger.info(messageSource.getMessage("object.findingAll", new Object[]{null}, Locale.getDefault()));
        return repository.findAll();
    }

    /**
     * Saves TeacherEntity and flushes changes instantly.
     *
     * @param teacher - saved teacher
     * @return TeacherEntity
     */
    @Override
    public TeacherEntity saveAndFlush(TeacherEntity teacher) {
        logger.info(messageSource.getMessage("object.creating", new Object[]{null}, Locale.getDefault()));
        return repository.saveAndFlush(teacher);
    }

    /**
     * This method get one TeacherEntity where column Id = TeacherEntity Id
     *
     * @param id - Teacher Id
     * @return TeacherEntity
     */
    @Override
    public TeacherEntity getOne(Integer id) {
        logger.info(messageSource.getMessage("object.receiving", new Object[]{null}, Locale.getDefault()));
        return repository.getOne(id);
    }

    /**
     * This method update teacher car field at TeacherEntity where teacher fio = fio
     *
     * @param car - new car Id
     * @param teacherFio      - current Teacher fio
     * @return int - count of changed rows
     */
    @Override
    public int updateTeacherEntityCar(int car, String teacherFio) {
        logger.info(messageSource.getMessage("object.field.updating", new Object[]{null}, Locale.getDefault()));
        return repository.updateTeacherEntityCar(car, teacherFio);
    }

    /**
     * This method delete Teacher Entity
     *
     * @param teacherId - Student entity
     * @return TeacherEntity
     */
    @Override
    public TeacherEntity deleteByTeacherId(Integer teacherId) {
        logger.info(messageSource.getMessage("object.deleting", new Object[]{null}, Locale.getDefault()));
        return repository.deleteByTeacherId(teacherId);
    }
}
