package com.example.logistics.services;

import com.example.logistics.dtos.CustomerDto;
import com.example.logistics.models.users.Customer;
import com.example.logistics.repositories.interfaces.CustomerRepository;
import com.example.logistics.repositories.interfaces.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceImplTests {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testCreateCustomer() {
        // Given
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUsername("john_doe");
        customerDto.setEmail("john@example.com");
        customerDto.setPhoneNumber("123456789");

        Customer customer = new Customer();
        customer.setId(1L);
        
        when(userRepository.save(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenReturn(customer);

        // When
        CustomerDto result = customerService.createCustomer(customerDto);

        // Then
        assertNotNull(result);
        assertEquals(customerDto.getUsername(), result.getUsername());
    }

    @Test
    void testUpdateCustomer() {
        // Given
        Long customerId = 1L;
        CustomerDto updatedCustomerDto = new CustomerDto();
        updatedCustomerDto.setPhoneNumber("987654321");

        Customer existingCustomer = new Customer();
        existingCustomer.setId(customerId);
        existingCustomer.setPhoneNumber("123456789");

        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // When
        CustomerDto result = customerService.updateCustomer(customerId, updatedCustomerDto);

        // Then
        assertNotNull(result);
        assertEquals(updatedCustomerDto.getPhoneNumber(), result.getPhoneNumber());
    }

    @Test
    void testDeleteCustomer() {
        // Given
        Long customerId = 1L;
        when(customerRepository.existsById(customerId)).thenReturn(true);

        // When
        customerService.deleteCustomer(customerId);

        // Then
        verify(customerRepository, times(1)).deleteById(customerId);
    }

    @Test
void testUpdateCustomerNotFound() {
    // Given
    Long customerId = 1L;
    CustomerDto updatedCustomerDto = new CustomerDto();
    updatedCustomerDto.setPhoneNumber("987654321");

    when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.empty());

    // When & Then
    assertThrows(RuntimeException.class, () -> customerService.updateCustomer(customerId, updatedCustomerDto),
                 "Customer not found with ID: " + customerId);
}
}
