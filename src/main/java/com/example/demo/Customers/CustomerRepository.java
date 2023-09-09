package com.example.demo.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> findCustomerById(int id);
    Optional<Customer> findCustomerByPhone(String phone);
}
