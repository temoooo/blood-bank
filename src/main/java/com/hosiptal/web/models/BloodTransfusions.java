package com.hosiptal.web.models;


import jakarta.persistence.*;

@Entity
@Table(name = "blood-transfusions")
public class BloodTransfusions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "initial-part",columnDefinition = "VARCHAR(255)",nullable = false)
    private String initialPart;

    @Column(name = "quantity",columnDefinition = "VARCHAR(255)",nullable = false)
    private String quantity;

    @Column(name = "blood-type",columnDefinition = "VARCHAR(255)",nullable = false)
    private String bloodType;

    @Column(name = "red-blood-cells",columnDefinition = "VARCHAR(255)",nullable = false)
    private String redBloodCells;

    @Column(name = "plasma",columnDefinition = "VARCHAR(255)",nullable = false)
    private String plasma;

    @Column(name = "platelets",columnDefinition = "VARCHAR(255)",nullable = false)
    private String platelets;

    @ManyToOne
    @JoinColumn(name = "employee-id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitialPart() {
        return initialPart;
    }

    public void setInitialPart(String initialPart) {
        this.initialPart = initialPart;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRedBloodCells() {
        return redBloodCells;
    }

    public void setRedBloodCells(String redBloodCells) {
        this.redBloodCells = redBloodCells;
    }

    public String getPlasma() {
        return plasma;
    }

    public void setPlasma(String plasma) {
        this.plasma = plasma;
    }

    public String getPlatelets() {
        return platelets;
    }

    public void setPlatelets(String platelets) {
        this.platelets = platelets;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
