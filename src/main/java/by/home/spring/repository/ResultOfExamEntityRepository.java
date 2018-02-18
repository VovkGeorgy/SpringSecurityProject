package by.home.spring.repository;

import by.home.spring.entity.ResultOfExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultOfExamEntityRepository extends JpaRepository<ResultOfExamEntity, Integer> {

    /**
     * Saves ResultOfExamEntity and flushes changes instantly.
     *
     * @param resultOfExam - saved result Of Exam
     * @return ResultOfExamEntity
     */
    @Override
    ResultOfExamEntity saveAndFlush(ResultOfExamEntity resultOfExam);

    /**
     * This method get one resultOfExam where column Id = resultOfExam Id
     *
     * @param id - result Of Exam Id
     * @return ResultOfExamEntity
     */
    @Override
    ResultOfExamEntity getOne(Integer id);

    /**
     * This method update passing field at ExamEntity where pk = pk
     *
     * @param passing - result of exam (passing)
     * @param pk        - current ResultOfExamEntity pk
     * @return int - count of changed rows
     */
    @Query(value = "update ResultOfExamEntity result set result.passing = ?1 where result.pk= ?2")
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
    @Override
    List<ResultOfExamEntity> findAll();

    /**
     * This method find and return entity of ResultOfExam type with ResultOfExamId = id
     *
     * @param id - ResultOfExam id
     * @return ResultOfExamEntity
     */
    ResultOfExamEntity findOne(Integer id);
}
