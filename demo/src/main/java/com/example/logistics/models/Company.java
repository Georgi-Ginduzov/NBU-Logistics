//package com.example.logistics.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Data
//public class Company {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    private String name;
//
//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
//    private List<Office> offices;
//}
