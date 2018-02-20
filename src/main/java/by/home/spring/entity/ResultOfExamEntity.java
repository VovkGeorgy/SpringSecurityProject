package by.home.spring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "result_of_exam", schema = "public", catalog = "firstDB")
@AssociationOverrides({
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "student_id")),
        @AssociationOverride(name = "pk.exam",
                joinColumns = @JoinColumn(name = "exam_id"))})

public class ResultOfExamEntity implements Serializable {
    private Boolean passing;
    private ResultOfExamId pk = new ResultOfExamId();

    public ResultOfExamEntity() {
    }

    /**
     * This method return field of object whose is an instance of a nested class
     *
     * @return pk
     */
    @EmbeddedId
    public ResultOfExamId getPk() {
        return pk;
    }

    public void setPk(ResultOfExamId pk) {
        this.pk = pk;
    }

    @Transient
    public StudentEntity getStudent() {
        return getPk().getStudent();
    }

    public void setStudent(StudentEntity student) {
        getPk().setStudent(student);
    }

    @Transient
    public ExamEntity getExam() {
        return getPk().getExam();
    }

    public void setExam(ExamEntity exam) {
        getPk().setExam(exam);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ResultOfExamEntity that = (ResultOfExamEntity) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    @Basic
    @Column(name = "passing")
    public Boolean getPassing() {
        return passing;
    }

    public void setPassing(Boolean passing) {
        this.passing = passing;
    }

}
