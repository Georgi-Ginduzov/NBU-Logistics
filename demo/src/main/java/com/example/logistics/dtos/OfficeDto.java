package com.example.logistics.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OfficeDto {
    private Long id;

    @NotBlank
    private String location;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;
}

