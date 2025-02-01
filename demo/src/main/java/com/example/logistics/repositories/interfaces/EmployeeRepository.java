package com.example.logistics.repositories.interfaces;

import com.example.logistics.models.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    /**
     * Find all employees associated with a specific office.
     * @param officeId The ID of the office.
     * @return List of employees in the given office.
     */
    List<Employee> findByOfficeId(Long officeId);

    /**
     * Find all employees by a specific position.
     * @param position The position of the employees to find.
     * @return List of employees with the given position.
     */
    List<Employee> findByPosition(String position);

    /**
     * Find employees by their name (case-insensitive).
     * @param name Name of the employee to find.
     * @return List of employees matching the given name.
     */
    List<Employee> findByNameIgnoreCase(String name);

    Optional<Employee> findByUsername(String username);
}
