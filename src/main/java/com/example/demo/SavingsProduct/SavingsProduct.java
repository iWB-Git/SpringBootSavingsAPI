package com.example.demo.SavingsProduct;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavingsProduct {
    public SavingsProduct() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SavingsProduct(Long id, String name, String description, double interestRate, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.interestRate = interestRate;
        this.type = type;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getType() {
        return type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double interestRate;
    private String type; // Enum representing the type (Education, Personal, Vacation)

    public void setName(String name) {
    }


}
