package by.home.spring.repository;

import by.home.spring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer> {

    /**
     * Saves StudentEntity and flushes changes instantly.
     *
     * @param student - saved student
     * @return StudentEntity
     */
    @Override
    StudentEntity saveAndFlush(StudentEntity student);

    /**
     * This method get one StudentEntity where column Id = StudentEntity Id
     *
     * @param id - Student Id
     * @return StudentEntity
     */
    @Override
    StudentEntity getOne(Integer id);

    /**
     * This method update yearsOld field at StudentEntity where fio = fio
     *
     * @param studentYearsOld - new YearsOld
     * @param studentFio      - current StudentEntity fio
     * @return int - count of changed rows
     */
    @Transactional
    @Modifying
    @Query(value = "update StudentEntity student set student.yearsOld= ?1 where student.fio= ?2")
    int updateStudentEntityYearsOld(int studentYearsOld, String studentFio);

    /**
     * This method delete Student Entity
     *
     * @param studentId - Student entity id
     * @return StudentEntity
     */
    @Transactional
    void deleteByStudentId(Integer studentId);

    /**
     * This method return all Student Entity
     *
     * @return List<StudentEntity>
     */
    @Override
    List<StudentEntity> findAll();

    StudentEntity findByFio(String fio);
}
