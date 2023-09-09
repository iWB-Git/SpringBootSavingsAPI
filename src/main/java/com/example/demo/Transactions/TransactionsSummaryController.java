package com.example.demo.SavingsProduct;

import com.example.demo.Transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/savings-summary")
public class TransactionsSummaryController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsSummaryController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Endpoint to get the total savings amount received across all users
    @GetMapping("/total")
    public ResponseEntity<Double> getTotalSavingsAmount() {
        double totalAmount = transactionService.getTotalSavingsAmount();
        return ResponseEntity.ok(totalAmount);
    }
}