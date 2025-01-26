package com.example.logistics.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

    // Getters and Setters
    private Long id;             // Customer ID
    private String username;     // User's username
    private String password;     // User's password
    private String email;        // User's email
    private String phoneNumber;  // Customer's phone number

}
