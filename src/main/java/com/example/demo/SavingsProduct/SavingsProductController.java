package com.example.demo.SavingsProduct;

import com.example.demo.Customers.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings-products")
@Api(value = "Savings Product Management", description = "Operations pertaining to savings products in the system.")
public class SavingsProductController {

    private final SavingsProductRepository savingsProductRepository;
    private final SavingsProductService savingsProductService;

    @Autowired
    public SavingsProductController(SavingsProductRepository savingsProductRepository, SavingsProductService savingsProductService) {
        this.savingsProductRepository = savingsProductRepository;
        this.savingsProductService = savingsProductService;
    }

//     Endpoint to create a new savings product
    @PostMapping("/create")
    public SavingsProduct createSavingsProduct(@RequestBody SavingsProduct savingsProduct) {
        return savingsProductService.saveSavingsProduct(savingsProduct);
    }


    // Endpoint to get all savings products
    @ApiOperation(value = "View a list of available savings products", response = List.class)
    @GetMapping("/all")
    public List<SavingsProduct> getAllSavingsProducts() {
        return savingsProductService.getSavingsTypes();
    }
//




    // Endpoint to delete a savings product
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSavingsProduct(@PathVariable Long id) {
        SavingsProduct existingProduct = savingsProductRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Savings product not found"));

        savingsProductRepository.delete(existingProduct);
        return ResponseEntity.ok().build();
    }
}