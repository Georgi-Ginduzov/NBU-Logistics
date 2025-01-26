package com.example.logistics.services.interfaces;

import com.example.logistics.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();
    /**
     * Get a customer by their ID.
     *
     * @param id the ID of the customer
     * @return a CustomerDto representing the customer
     */
    CustomerDto getCustomerById(Long id);

    /**
     * Get the currently authenticated customer's details.
     *
     * @return a CustomerDto representing the currently authenticated customer
     */
    CustomerDto getCurrentCustomer();

    /**
     * Create a new customer in the system.
     *
     * @param customerDto the details of the customer to be created
     * @return a CustomerDto of the created customer
     */
    CustomerDto createCustomer(CustomerDto customerDto);

    /**
     * Update an existing customer's details.
     *
     * @param id          the ID of the customer to update
     * @param customerDto the updated customer details
     * @return a CustomerDto of the updated customer
     */
    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

    /**
     * Delete a customer by their ID.
     *
     * @param id the ID of the customer to delete
     */
    void deleteCustomer(Long id);
}
