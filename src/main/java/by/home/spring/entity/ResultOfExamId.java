package by.home.spring.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * annotation Embeddable indicate a class whose instances and stored as an part of the owner-object (ResultOfExamId)
 */
@Embeddable
public class ResultOfExamId implements Serializable {

    private StudentEntity student;
    private ExamEntity exam;

    @ManyToOne
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity stock) {
        this.student = stock;
    }

    @ManyToOne
    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultOfExamId that = (ResultOfExamId) o;

        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (exam != null ? !exam.equals(that.exam) : that.exam != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (student != null ? student.hashCode() : 0);
        result = 31 * result + (exam != null ? exam.hashCode() : 0);
        return result;
    }

}
