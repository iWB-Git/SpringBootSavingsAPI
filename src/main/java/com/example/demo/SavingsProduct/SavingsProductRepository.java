package com.example.demo.SavingsProduct;

import com.example.demo.Customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavingsProductRepository extends
        JpaRepository<SavingsProduct, Long> {
    List<SavingsProduct> findByType(String type);
}