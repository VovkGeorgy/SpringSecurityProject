package by.home.spring.service;

import by.home.spring.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    /**
     * Saves StudentEntity and flushes changes instantly.
     *
     * @param student - saved student
     * @return StudentEntity
     */
    StudentEntity saveAndFlush(StudentEntity student);

    /**
     * This method get one StudentEntity where column Id = StudentEntity Id
     *
     * @param id - Student Id
     * @return StudentEntity
     */
    StudentEntity getOne(Integer id);

    /**
     * This method update yearsOld field at StudentEntity where fio = fio
     *
     * @param studentYearsOld - new YearsOld
     * @param studentFio      - current StudentEntity fio
     * @return int - count of changed rows
     */
    int updateStudentEntityYearsOld(int studentYearsOld, String studentFio);

    /**
     * This method delete Student Entity
     *
     * @param studentId - Student entity id
     * @return StudentEntity
     */
    String deleteByStudentId(Integer studentId);

    /**
     * This method return all Student Entity
     *
     * @return List<StudentEntity>
     */
    List<StudentEntity> findAll();

    StudentEntity findByFio(String fio);

}
