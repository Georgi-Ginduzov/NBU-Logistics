package com.example.logistics.services.interfaces;

import com.example.logistics.models.users.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService{
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getEmployeesByOffice(Long officeId);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);
}
