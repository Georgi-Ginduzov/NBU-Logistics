package com.example.logistics.services;

import com.example.logistics.models.users.Employee;
import com.example.logistics.repositories.interfaces.EmployeeRepository;
import com.example.logistics.services.interfaces.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testGetAllEmployees() {
        // Given
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        // When
        var employees = employeeService.getAllEmployees();

        // Then
        assertNotNull(employees);
        assertEquals(2, employees.size());
    }

    @Test
    void testGetEmployeeById() {
        // Given
        Long employeeId = 1L;
        Employee employee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // When
        Optional<Employee> result = employeeService.getEmployeeById(employeeId);

        // Then
        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    void testSaveEmployee() {
        // Given
        Employee employee = new Employee();
        when(employeeRepository.save(employee)).thenReturn(employee);

        // When
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // Then
        assertNotNull(savedEmployee);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testDeleteEmployee() {
        // Given
        Long employeeId = 1L;
        when(employeeRepository.existsById(employeeId)).thenReturn(true);

        // When
        employeeService.deleteEmployee(employeeId);

        // Then
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }
}
