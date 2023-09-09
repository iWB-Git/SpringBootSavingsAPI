package com.example.demo.Customers;

import com.example.demo.Transactions.Transaction;
import com.example.demo.Transactions.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public void updateCustomerTransactionAmount(int customerId, double transactionAmount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer not found"));

        double updatedTransactionAmount = customer.getTransactions() + transactionAmount;
        customer.setTransactions(updatedTransactionAmount);

        customerRepository.save(customer);
    }
    public void addNewCustomer(Customer customer){

        //checkEmailUnique
        Optional<Customer> customerByEmail= customerRepository.
                findCustomerByEmail(customer.getEmail());
        if(customerByEmail.isPresent()){
            throw new IllegalStateException("Email already in use");
        }


        Optional<Customer> customerByPhone= customerRepository.
                findCustomerByPhone(customer.getPhone());
        if(customerByPhone.isPresent()){
            throw new IllegalStateException("Phone already in use");
        }

        //checkIdUnique
        Optional<Customer> customerById= customerRepository.
                findCustomerById(customer.getId());
        if(customerById.isPresent()){
            throw new IllegalStateException("ID already in use");
        }
        customerRepository.save(customer);

    }

    public double getTotalSavingsAmountForCustomer(int customerId) {
        // Find the customer by their ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer not found"));

        // Get the customer's transactions

        List<Transaction> customerTransactions = transactionRepository.findByCustomer(customer);

        // Calculate the total savings amount for the customer
        double totalSavingsAmount = customerTransactions.stream()
                .mapToDouble(Transaction::getAmmount)
                .sum();

        return totalSavingsAmount;
    }
}
