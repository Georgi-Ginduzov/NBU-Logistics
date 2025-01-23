package com.example.logistics.models.users;

import com.example.logistics.models.Office;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING) // Store enum as String in the DB
    @Column(name = "role")
    private EmployeeTypes position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
