package by.home.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam", schema = "public", catalog = "firstDB")
public class ExamEntity implements Serializable {
    private Integer examId;
    private String examType;
    private String examTopic;
    private Integer ticketNumber;
    private Set<ResultOfExamEntity> resultOfExam = new HashSet<>(0);

    public ExamEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id", nullable = false)
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    @Basic
    @Column(name = "exam_type", length = -1)
    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    @Basic
    @Column(name = "exam_topic", length = -1)
    public String getExamTopic() {
        return examTopic;
    }

    public void setExamTopic(String examTopic) {
        this.examTopic = examTopic;
    }

    @Basic
    @Column(name = "ticket_number")
    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.exam")
    public Set<ResultOfExamEntity> getResultOfExam() {
        return this.resultOfExam;
    }

    public void setResultOfExam(Set<ResultOfExamEntity> resultOfExam) {
        this.resultOfExam = resultOfExam;
    }

}
