package by.home.spring.service.impl;

import by.home.spring.entity.StudentEntity;
import by.home.spring.repository.StudentEntityRepository;
import by.home.spring.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentEntityRepository repository;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    /**
     * Saves StudentEntity and flushes changes instantly.
     *
     * @param student - saved student
     * @return StudentEntity
     */
    @Override
    public StudentEntity saveAndFlush(StudentEntity student) {
        logger.info(messageSource.getMessage("object.creating", new Object[]{null}, Locale.getDefault()));
        return repository.saveAndFlush(student);
    }

    /**
     * This method get one StudentEntity where column Id = StudentEntity Id
     *
     * @param id - Student Id
     * @return StudentEntity
     */
    @Override
    public StudentEntity getOne(Integer id) {
        logger.info(messageSource.getMessage("object.receiving", new Object[]{null}, Locale.getDefault()));
        return repository.getOne(id);
    }

    /**
     * This method update yearsOld field at StudentEntity where fio = fio
     *
     * @param studentYearsOld - new YearsOld
     * @param studentFio      - current StudentEntity fio
     * @return int - count of changed rows
     */
    @Override
    public int updateStudentEntityYearsOld(int studentYearsOld, String studentFio) {
        logger.info(messageSource.getMessage("object.field.updating", new Object[]{null}, Locale.getDefault()));
        return repository.updateStudentEntityYearsOld(studentYearsOld, studentFio);
    }

    /**
     * This method delete Student Entity
     *
     * @param studentId - Student entity id
     * @return StudentEntity
     */
    @Override
    public StudentEntity deleteByStudentId(Integer studentId) {
        logger.info(messageSource.getMessage("object.deleting", new Object[]{null}, Locale.getDefault()));
        return repository.deleteByStudentId(studentId);
    }

    /**
     * This method return all Student Entity
     *
     * @return List<StudentEntity>
     */
    @Override
    public List<StudentEntity> findAll() {
        logger.info(messageSource.getMessage("object.findingAll", new Object[]{null}, Locale.getDefault()));
        return repository.findAll();
    }
}
