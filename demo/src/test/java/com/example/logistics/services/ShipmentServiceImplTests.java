package com.example.logistics.services;

import com.example.logistics.dtos.ShipmentDto;
import com.example.logistics.models.Shipment;
import com.example.logistics.repositories.interfaces.ShipmentRepository;
import com.example.logistics.services.interfaces.ShipmentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ShipmentServiceImplTests {

    @Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    @Test
    void testFindAll() {
        // Given
        Shipment shipment1 = new Shipment();
        Shipment shipment2 = new Shipment();
        when(shipmentRepository.findAll()).thenReturn(Arrays.asList(shipment1, shipment2));

        // When
        List<ShipmentDto> shipments = shipmentService.findAll();

        // Then
        assertNotNull(shipments);
        assertEquals(2, shipments.size());
    }

    @Test
    void testFindById() {
        // Given
        Long shipmentId = 1L;
        Shipment shipment = new Shipment();
        when(shipmentRepository.findById(shipmentId)).thenReturn(Optional.of(shipment));

        // When
        Optional<ShipmentDto> result = shipmentService.find(shipmentId);

        // Then
        assertTrue(result.isPresent());
        assertEquals(shipment, result.get());
    }

    @Test
    void testAddShipment() {
        // Given
        ShipmentDto shipmentDto = new ShipmentDto();
        Shipment shipment = new Shipment();
        when(shipmentRepository.save(any(Shipment.class))).thenReturn(shipment);

        // When
        Long result = shipmentService.add(shipmentDto);

        // Then
        assertNotNull(result);
    }

    @Test
    void testDeleteShipment() {
        // Given
        Long shipmentId = 1L;

        // When
        shipmentService.delete(shipmentId);

        // Then
        verify(shipmentRepository, times(1)).deleteById(shipmentId);
    }
}
