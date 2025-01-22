package com.example.logistics.services;

import com.example.logistics.models.users.Employee;
import com.example.logistics.repositories.interfaces.EmployeeRepository;
import com.example.logistics.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        var employees = employeeRepository.findAll();

        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByOffice(Long officeId) {
        return employeeRepository.findByOfficeId(officeId);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return employeeRepository.existsById(id);
    }
}
