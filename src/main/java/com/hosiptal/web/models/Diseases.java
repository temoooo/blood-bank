package com.hosiptal.web.models;


import jakarta.persistence.*;

@Entity
@Table(name = "diseases")
public class Diseases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content-exam" ,columnDefinition = "VARCHAR(255)", nullable = false)
    private String contentExam;

    @Column(name = "examination-date" ,columnDefinition = "VARCHAR(255)", nullable = false)
    private String examinationDate;

    @ManyToOne
    @JoinColumn(name = "downer-id")
    private Downer downer;

    public String getContentExam() {
        return contentExam;
    }

    public String getExaminationDate() {
        return examinationDate;
    }

    public Downer getDowner() {
        return downer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContentExam(String contentExam) {
        this.contentExam = contentExam;
    }

    public void setExaminationDate(String examinationDate) {
        this.examinationDate = examinationDate;
    }

    public void setDowner(Downer downer) {
        this.downer = downer;
    }
}
