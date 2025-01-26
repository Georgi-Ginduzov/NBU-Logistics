package com.example.logistics.services;

import com.example.logistics.dtos.CustomerDto;
import com.example.logistics.models.users.Customer;
import com.example.logistics.models.users.RoleType;
import com.example.logistics.models.users.User;
import com.example.logistics.repositories.interfaces.CustomerRepository;
import com.example.logistics.repositories.interfaces.UserRepository;
import com.example.logistics.services.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        return mapToDto(customer);
    }

    @Override
    public CustomerDto getCurrentCustomer() {
        throw new UnsupportedOperationException("Security for retrieving the current customer is not yet implemented.");
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        // Step 1: Create a new User for the Customer
        User user = new User();
        user.setUsername(customerDto.getUsername());
        user.setPassword(customerDto.getPassword()); // Ideally, encode the password
        user.setEmail(customerDto.getEmail());
        user.setRoles(Collections.singleton(RoleType.CUSTOMER));
        User savedUser = userRepository.save(user);

        // Step 2: Create the Customer and associate it with the User
        Customer customer = new Customer();
        customer.setUser(savedUser);
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        Customer savedCustomer = customerRepository.save(customer);

        // Step 3: Return the mapped CustomerDto
        return mapToDto(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

        customer.setPhoneNumber(customerDto.getPhoneNumber());
        Customer updatedCustomer = customerRepository.save(customer);
        return mapToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    // Helper Method: Map Customer to CustomerDto
    private CustomerDto mapToDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setUsername(customer.getUser().getUsername());
        dto.setEmail(customer.getUser().getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        return dto;
    }

    // Helper Method: Map CustomerDto to Customer Entity
    private Customer mapToEntity(CustomerDto customerDto, User user) {
        Customer customer = new Customer();
        customer.setUser(user);
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        return customer;
    }
}
