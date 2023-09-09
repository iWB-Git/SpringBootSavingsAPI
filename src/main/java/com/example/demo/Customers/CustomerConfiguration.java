package com.example.demo.Customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository){
        return args -> {
            Customer hamza=new Customer(
                    "hamza",
                    1,
                    "0712728786",
                    "hamza@gmail.com",
                    12
            );
            Customer hm=new Customer(
                    "ha2mza",
                    7,
                    "071222728786",
                    "hamza@gmail.com",
                    14
            );

            repository.saveAll(
                    List.of(hamza,hm)
            );

        };
    }
}
