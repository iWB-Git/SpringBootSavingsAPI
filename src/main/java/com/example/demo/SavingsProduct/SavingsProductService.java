package com.example.demo.SavingsProduct;

import com.example.demo.Customers.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SavingsProductService {
    private final SavingsProductRepository savingsProductRepository;

    @Autowired
    public SavingsProductService(SavingsProductRepository savingsProductRepository) {
        this.savingsProductRepository = savingsProductRepository;
    }
    public List<SavingsProduct> getSavingsTypes(){
        return savingsProductRepository.findAll();
    }

    public List<SavingsProduct> findByType(String type){
        return savingsProductRepository.findByType(type);
    }

    public SavingsProduct saveSavingsProduct(SavingsProduct savingsProduct) {
        return savingsProductRepository.save(savingsProduct);

    }
}