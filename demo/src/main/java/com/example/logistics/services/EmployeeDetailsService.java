//package com.example.logistics.services;
//
//import com.example.logistics.models.users.Employee;
//import com.example.logistics.models.users.User;
//import com.example.logistics.repositories.interfaces.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//@Service
//public class EmployeeDetailsService implements UserDetailsService {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User exampleUser = new User();
//        exampleUser.setUsername(username);
//        Employee employee = employeeRepository
//                .findOne(Example.of(new Employee(exampleUser)))
//                .orElse(null);
//
//        if (employee == null) {throw new UsernameNotFoundException("User does not exist");}
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(employee.getUser().getUsername())
//                .password(employee.getUser().getPassword())
//                .build();
//    }
//}
