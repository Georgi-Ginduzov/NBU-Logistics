package com.example.logistics.controllers;

import com.example.logistics.dtos.OfficeDto;
import com.example.logistics.services.interfaces.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeDto> getOffice(@PathVariable Long id) {
        return ResponseEntity.ok(officeService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<OfficeDto>> getAllOffices() {
        return ResponseEntity.ok(officeService.findAll());
    }

    @PostMapping
    public ResponseEntity<OfficeDto> createOffice(@RequestBody OfficeDto officeDto) {
        return ResponseEntity.ok(officeService.add(officeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfficeDto> updateOffice(@PathVariable Long id, @RequestBody OfficeDto officeDto) {
        return ResponseEntity.ok(officeService.update(id, officeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long id) {
        officeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

