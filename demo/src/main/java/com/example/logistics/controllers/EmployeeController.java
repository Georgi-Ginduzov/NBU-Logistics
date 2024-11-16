//package com.example.logistics.controllers;
//
//import com.example.logistics.dto.EmployeeDto;
//import com.example.logistics.service.interfaces.EmployeeService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/public/employees")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping
//    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
//        List<EmployeeDto> users = employeeService.GetAllEmployees();
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeDto> getUserById(@PathVariable Long id) {
//        EmployeeDto user = employeeService.Find(id);
//        return ResponseEntity.ok(user);
//    }
//
//
//}
