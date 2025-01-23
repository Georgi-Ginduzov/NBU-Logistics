package com.example.logistics.controllers;

import com.example.logistics.dtos.ShipmentDto;
import com.example.logistics.services.interfaces.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShipmentController {
    private final ShipmentService _shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService){
        _shipmentService = shipmentService;
    }

    @GetMapping("/shipments")
    public List<ShipmentDto> findAll(){
        return _shipmentService.findAll();
    }

    @GetMapping("/shipments/{id}")
    public Optional<ShipmentDto> find(@PathVariable Long id){
        return _shipmentService.find(id);
    }

    @PostMapping("/shipments")
    public Long add(@Valid @RequestBody ShipmentDto shipmentDto){
        return _shipmentService.add(shipmentDto);
    }

    @PutMapping("/shipments")
    public Long update(@Valid @RequestBody ShipmentDto shipmentDto){
        return _shipmentService.update(shipmentDto);
    }

    @DeleteMapping("/shipments/{id}")
    public void delete(@PathVariable Long id){
        _shipmentService.delete(id);;
    }
}
