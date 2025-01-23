package com.example.logistics.services.interfaces;

import com.example.logistics.dtos.OfficeDto;

import java.util.List;

public interface OfficeService {
    OfficeDto find(Long id);

    List<OfficeDto> findAll();

    OfficeDto add(OfficeDto officeDto);

    OfficeDto update(Long id, OfficeDto officeDto);

    void delete(Long id);
}
