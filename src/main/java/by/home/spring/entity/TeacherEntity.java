package by.home.spring.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher", schema = "public", catalog = "firstDB")
public class TeacherEntity {
    private Integer teacherId;
    private String fio;
    private Integer experience;
    private Integer studentsNumber;
    private CarEntity car;
    private Set<StudentEntity> student = new HashSet<StudentEntity>(
            0);

    public TeacherEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
    @Column(name = "experience")
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "students_number")
    public Integer getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(Integer studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (!teacherId.equals(that.teacherId)) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (studentsNumber != null ? !studentsNumber.equals(that.studentsNumber) : that.studentsNumber != null)
            return false;

        return true;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    public Set<StudentEntity> getStudent() {
        return this.student;
    }

    public void setStudent(Set<StudentEntity> student) {
        this.student = student;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "teacher", cascade = CascadeType.ALL)
    public CarEntity getCar() {
        return this.car;
    }

}
