package by.home.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student", schema = "public", catalog = "firstDB")
public class StudentEntity implements Serializable {
    private Integer studentId;
    private String fio;
    private Integer workGroup;
    private Integer yearsOld;
    private TeacherEntity teacher;
    private Set<ResultOfExamEntity> resultOfExams = new HashSet<>(0);

    public StudentEntity(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "fio", length = -1)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "work_group")
    public Integer getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(Integer workGroup) {
        this.workGroup = workGroup;
    }

    @Basic
    @Column(name = "years_old")
    public Integer getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(Integer yearsOld) {
        this.yearsOld = yearsOld;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    public TeacherEntity getTeacher() {
        return this.teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher= teacher;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.student", cascade=CascadeType.ALL)
    public Set<ResultOfExamEntity> getResultOfExam() {
        return this.resultOfExams;
    }

    public void setResultOfExam(Set<ResultOfExamEntity> resultOfExams) {
        this.resultOfExams = resultOfExams;
    }
}
