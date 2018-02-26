package by.home.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "car", schema = "public", catalog = "firstDB")
public class CarEntity {
    private Integer carId;
    private String mark;
    private String regNumber;
    private Integer mileage;
    private TeacherEntity teacher;

    public CarEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public TeacherEntity getTeacher() {
        return this.teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "mark", length = -1)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "reg_number", length = -1)
    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Basic
    @Column(name = "mileage")
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity car = (CarEntity) o;
        if (!carId.equals(car.carId)) return false;
        if (mark != null ? !mark.equals(car.mark) : car.mark != null) return false;
        if (regNumber != null ? !regNumber.equals(car.regNumber) : car.regNumber != null) return false;
        if (mileage != null ? !mileage.equals(car.mileage) : car.mileage != null) return false;
        return true;
    }

}
