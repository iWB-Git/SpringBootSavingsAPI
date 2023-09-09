package com.example.demo.Transactions;

import com.example.demo.Customers.Customer;
import com.example.demo.Customers.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TransactionConfiguration {
    private final CustomerService customerService;

    public TransactionConfiguration(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Bean
    CommandLineRunner commandLineRunnerT(
            TransactionRepository repository){
        return args -> {
            Transaction n=new Transaction(
                    1221,
                    "MPESA",
                    1200,
                    new Customer("hamza", 1, "0712728786", "hamza@gmail.com", 1)
            );
            Transaction x=new Transaction(
                    1223,
                    "PAYPAL",
                    2500,
                    new Customer("ha2mza", 7, "071222728786", "hamza@gmail.com", 2)
            );

            repository.saveAll(
                    List.of(n,x)
            );

        };
    }
}
