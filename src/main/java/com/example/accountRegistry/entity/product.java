package com.example.accountRegistry.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class product {

@Id
@SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1, initialValue = 1000)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
private int id;
    private int Coffee;
    @Column(name = "herbal_pills")
    private int herbalPills;
    private int tea;
    private int medication;
    private int accountID;

    public product(int id, int coffee, int herbalPills, int tea, int medication, int accountID) {
        super();
        this.id = id;
        this.Coffee = coffee;
        this.herbalPills = herbalPills;
        this.tea = tea;
        this.medication = medication;
        this.accountID = accountID;
    }
    public product(){
        super();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getCoffee() {
        return Coffee;
    }

    public void setCoffee(int coffee) {
        this.Coffee = coffee;
    }

    public int getHerbalPills() {
        return herbalPills;
    }

    public void setHerbalPills(int herbalPills) {
        this.herbalPills = herbalPills;
    }

    public int getTea() {
        return tea;
    }

    public void setTea(int tea) {
        this.tea = tea;
    }

    public int getMedication() {
        return medication;
    }

    public void setMedication(int medication) {
        this.medication = medication;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
