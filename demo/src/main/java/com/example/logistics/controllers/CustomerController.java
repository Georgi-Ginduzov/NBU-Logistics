package com.example.logistics.controllers;

import com.example.logistics.dtos.CustomerDto;
import com.example.logistics.services.interfaces.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    /**
     * Get a customer by their ID.
     *
     * @param id the ID of the customer
     * @return a ResponseEntity containing the CustomerDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    /**
     * Create a new customer.
     *
     * @param customerDto the details of the customer to create
     * @return a ResponseEntity containing the created CustomerDto
     */
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    /**
     * Update an existing customer.
     *
     * @param id          the ID of the customer to update
     * @param customerDto the updated customer details
     * @return a ResponseEntity containing the updated CustomerDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    /**
     * Delete a customer by their ID.
     *
     * @param id the ID of the customer to delete
     * @return a ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
