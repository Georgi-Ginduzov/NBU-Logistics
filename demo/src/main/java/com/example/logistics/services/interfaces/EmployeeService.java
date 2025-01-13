package com.example.logistics.services.interfaces;

import com.example.logistics.models.users.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService{
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getEmployeesByOffice(Long officeId);

    Employee saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);
}
