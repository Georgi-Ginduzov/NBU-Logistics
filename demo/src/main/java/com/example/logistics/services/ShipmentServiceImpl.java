package com.example.logistics.services;

import com.example.logistics.dtos.ShipmentDto;
import com.example.logistics.models.Shipment;
import com.example.logistics.repositories.interfaces.ShipmentRepository;
import com.example.logistics.services.interfaces.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository _shipmentRepo;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository){
        _shipmentRepo = shipmentRepository;
    }

    @Override
    public Optional<ShipmentDto> find(Long id) {
        return _shipmentRepo.findById(id).map(this::mapToDto);
    }

    @Override
    public List<ShipmentDto> findAll() {
        return _shipmentRepo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Long add(ShipmentDto shipmentDto) {
        Shipment saved =  _shipmentRepo.save(mapToEntity(shipmentDto));
        return saved.getId();
    }

    @Override
    public Long update(ShipmentDto shipmentDto) {
        //TODO: implement update logic
        return 0L;
    }

    @Override
    public void delete(Long id) {
        _shipmentRepo.deleteById(id);
    }

    private ShipmentDto mapToDto(Shipment shipment){
        ShipmentDto dto = new ShipmentDto();
        //TODO map properties

        return dto;
    }

    private Shipment mapToEntity(ShipmentDto dto){
        Shipment shipment = new Shipment();
        //TODO: map properties
        return shipment;
    }
}
