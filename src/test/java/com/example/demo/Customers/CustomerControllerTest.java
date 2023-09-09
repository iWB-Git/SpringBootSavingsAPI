package com.example.demo.Customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@Import(TestConfig.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        customers = new ArrayList<>();
        customers.add(new Customer("Alice", 1, "123456", "alice@example.com", 101));
        customers.add(new Customer("Bob", 2, "789012", "bob@example.com", 102));
    }

    @Test
    void testGetCustomers() throws Exception {
        when(customerService.getCustomers()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(customers.size()));
    }

    // Add more test cases for other endpoints as needed
}
