package com.example.logistics.utilities;

import com.example.logistics.models.Office;
import com.example.logistics.models.users.Employee;
import com.example.logistics.models.users.RoleType;
import com.example.logistics.models.users.User;
import com.example.logistics.repositories.interfaces.EmployeeRepository;
import com.example.logistics.repositories.interfaces.OfficeRepository;
import com.example.logistics.repositories.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initAdminUser(UserRepository userRepository, OfficeRepository officeRepository, EmployeeRepository employeeRepository)
    {
        return args -> {
            Employee adminEmployee = employeeRepository.findById(1L).orElse(null);

            if (adminEmployee == null) {
                User newAdmin = new User();
                newAdmin.setUsername("dev");
                newAdmin.setEmail("dev@example.com");
                newAdmin.setPassword(passwordEncoder.encode("secret"));
                newAdmin.addRole(RoleType.ADMIN);

                Employee newAadminEmployee = new Employee(newAdmin);
                Office centralOffice = officeRepository.findById(1L).orElse(null);

                newAadminEmployee.setOffice(centralOffice);
                newAadminEmployee.setName("dev-admin");
                employeeRepository.save(newAadminEmployee);

                userRepository.save(newAdmin);
            }
        };
    }
}
