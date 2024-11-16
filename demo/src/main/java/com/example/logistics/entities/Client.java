package com.example.logistics.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data // анотация от lombok автоматично генерира гетъри, сетъри, tostring, equals, hashcode, constructor без аргументи
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;
}
