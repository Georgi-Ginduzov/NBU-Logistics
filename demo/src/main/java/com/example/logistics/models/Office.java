package com.example.logistics.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "offices")
@Data
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String phone;
}

