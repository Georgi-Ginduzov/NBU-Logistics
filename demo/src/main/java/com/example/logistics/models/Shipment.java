package com.example.logistics.models;

import com.example.logistics.models.users.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "shipments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Shipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}