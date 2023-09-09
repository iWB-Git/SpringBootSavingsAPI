package com.example.demo.Transactions;

import com.example.demo.Customers.Customer;
import com.example.demo.Customers.CustomerRepository;
import com.example.demo.Customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CustomerService customerService, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    public List<Transaction> getTransaction() {
        return transactionRepository.findAll();
    }

    public void addNewTransaction(Transaction transaction) {
        if (transaction.getAmmount() < 1000) {
            throw new IllegalStateException("Amount insufficient for saving");
        }

        if (transaction.getPaymentMethod().isEmpty() || transaction.getPaymentMethod() == null ) {
            throw new IllegalStateException("Payment method not defined");
        }
        Customer customer = customerRepository.findById(transaction.getCustomer().getId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found."));

        // Save the transaction
        transactionRepository.save(transaction);

        // Update the customer's transaction amount
        customerService.updateCustomerTransactionAmount(transaction.getCustomer().getMemNumber(), transaction.getAmmount());
    }
    public double getTotalSavingsAmount() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .mapToDouble(Transaction::getAmmount)
                .sum();
    }

}
