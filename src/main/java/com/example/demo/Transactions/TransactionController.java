package com.example.demo.Transactions;

import com.example.demo.Customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final CustomerService customerService;
    @Autowired
    public TransactionController(TransactionService transactionService, CustomerService customerService) {
        this.transactionService = transactionService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Transaction> getTransaction(){
        return transactionService.getTransaction();
    }
    @GetMapping("/total-savings")
    public double getTotalSavingsAmount() {
        return transactionService.getTotalSavingsAmount();
    }
    @GetMapping("/{customerId}/total-savings")
    public ResponseEntity<Double> getTotalSavingsAmountForCustomer(@PathVariable int customerId) {
        double totalAmount = customerService.getTotalSavingsAmountForCustomer(customerId);
        return ResponseEntity.ok(totalAmount);
    }
    @PostMapping
    public void AddTransaction(@RequestBody Transaction transaction){
        transactionService.addNewTransaction(transaction);
    }
    // ADD PUT MAPPING TO UPDATE THE TRANSACTION SUM IN CUSTOMER

}

