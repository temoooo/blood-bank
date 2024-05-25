package com.hosiptal.web.models;


import jakarta.persistence.*;

@Entity
@Table(name = "blood-store")
public class BloodStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood-type",columnDefinition = "VARCHAR(255)",nullable = false)
    private String bloodType;

    @Column(name = "quantity", columnDefinition = "VARCHAR(255)", nullable = false)
    private String quantity;

    @Column(name = "red-blood-cells",columnDefinition = "VARCHAR(255)",nullable = false)
    private String redBloodCells;

    @Column(name = "plasma",columnDefinition = "VARCHAR(255)",nullable = false)
    private String plasma;

    @Column(name = "platelets",columnDefinition = "VARCHAR(255)",nullable = false)
    private String platelets;

    @ManyToOne
    @JoinColumn(name = "supervisor-id")
    private Supervisor supervisor;

    public BloodStore(Long id, String bloodType,String quantity, String redBloodCells, String plasma, String platelets, Supervisor supervisor) {
        this.id = id;
        this.quantity = quantity;
        this.bloodType = bloodType;
        this.redBloodCells = redBloodCells;
        this.plasma = plasma;
        this.platelets = platelets;
        this.supervisor = supervisor;
    }

    public BloodStore(String bloodType,String quantity, String redBloodCells, String plasma, String platelets, Supervisor supervisor) {
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.redBloodCells = redBloodCells;
        this.plasma = plasma;
        this.platelets = platelets;
        this.supervisor = supervisor;
    }

    public BloodStore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
