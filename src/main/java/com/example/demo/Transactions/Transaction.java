package com.example.demo.Transactions;

import com.example.demo.Customers.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Entity
@Table
public class Transaction {



    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transcationId;
    private String paymentMethod;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "memberNumber")
    private Customer customer;

    public Transaction() {

    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTranscationId(int transcationId) {
        this.transcationId = transcationId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmmount(double ammount) {
        this.amount = ammount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public int getTranscationId() {
        return transcationId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Transaction(int transcationId, String paymentMethod, double amount, Customer customer) {
        this.transcationId = transcationId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date=(dtf.format(now));
        this.customer=customer;
    }
}
