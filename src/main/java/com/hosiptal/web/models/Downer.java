package com.hosiptal.web.models;


import jakarta.persistence.*;

@Entity
@Table(name = "downer")
public class Downer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @Column(name = "phone", columnDefinition = "VARCHAR(255)", nullable = false)
    private String phone;

    @Column(name = "blood-type", columnDefinition = "VARCHAR(255)", nullable = false)
    private String bloodType;

    @Column(name = "weight", columnDefinition = "VARCHAR(255)", nullable = false)
    private String weight;

    @Column(name = "medical-examinations", columnDefinition = "VARCHAR(255)", nullable = false)
    private String medicalExaminations;

    @ManyToOne
    @JoinColumn(name = "employee-id")
    private Employee employee;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setMedicalExaminations(String medicalExaminations) {
        this.medicalExaminations = medicalExaminations;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getWeight() {
        return weight;
    }

    public String getMedicalExaminations() {
        return medicalExaminations;
    }

    public Employee getEmployee() {
        return employee;
    }
}
