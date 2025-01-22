package com.example.logistics.repositories.interfaces;

import com.example.logistics.models.users.Customer;
import com.example.logistics.models.users.Employee;
import com.example.logistics.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r = 'EMPLOYEE'")
    List<Employee> getEmployees();

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r = 'EMPLOYEE' or r = 'ADMIN'")
    List<Employee> getEmployeesAndAdmins();

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r = 'CUSTOMER'")
    List<Customer> getCustomers();
}
