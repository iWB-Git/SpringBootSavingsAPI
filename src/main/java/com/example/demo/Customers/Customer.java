package com.example.demo.Customers;



import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name="customer_sequence",
            sequenceName="customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private int memNumber;
    private int id;
    private String name;

    private String phone;

    public void setTransactions(double transactions) {
        this.transactions = transactions;
    }

    private String email;

    public double getTransactions() {
        return transactions;
    }

    private double transactions;


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemNumber(int memNumber) {
        this.memNumber = memNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getMemNumber() {
        return memNumber;
    }


    public Customer() {
        // Initialize any default values if needed
    }
    public Customer(String name, int id, String phone, String email, int memNumber) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.memNumber = memNumber;
        this.transactions=0;
    }



}
