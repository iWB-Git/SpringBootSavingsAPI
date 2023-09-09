package com.example.demo.Transactions;

import com.example.demo.Customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCustomer(Customer customer);

//    Optional<Customer> findCustomerByEmail(String email);
//    Optional<Customer> findCustomerById(int id);
//    Optional<Customer> findCustomerByPhone(String phone);
}
