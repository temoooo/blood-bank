package com.hosiptal.web.models;

import jakarta.persistence.*;

@Entity
@Table(name = "donate-history")
public class DonateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "donate-date", columnDefinition = "VARCHAR(255)", nullable = false)
    private String donateDate;

    @Column(name = "blood-type", columnDefinition = "VARCHAR(255)", nullable = false)
    private String bloodType;

    @Column(name = "quantity", columnDefinition = "VARCHAR(255)", nullable = false)
    private String quantity;

    @Column(name = "red-blood-cells", columnDefinition = "VARCHAR(255)", nullable = false)
    private String redBloodCells;

    @Column(name = "plasma", columnDefinition = "VARCHAR(255)", nullable = false)
    private String plasma;

    @Column(name = "platelets", columnDefinition = "VARCHAR(255)", nullable = false)
    private String platelets;

    @ManyToOne
    @JoinColumn(name = "downer-id")
    private Downer downer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(String donateDate) {
        this.donateDate = donateDate;
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

    public Downer getDowner() {
        return downer;
    }

    public void setDowner(Downer downer) {
        this.downer = downer;
    }
}
