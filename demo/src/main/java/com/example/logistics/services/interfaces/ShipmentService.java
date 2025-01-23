package com.example.logistics.services.interfaces;

import com.example.logistics.dtos.ShipmentDto;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

    /**
     * Find a shipment by its ID.
     *
     * @param id the shipment ID
     * @return an Optional containing the Shipment if found, or empty if not
     */
    Optional<ShipmentDto> find(Long id);

    /**
     * Retrieve all shipments.
     *
     * @return a list of all shipments
     */
    List<ShipmentDto> findAll();

    /**
     * Add a new shipment.
     *
     * @param shipmentDto the data transfer object for the shipment
     * @return the ID of the newly created shipment
     */
    Long add(ShipmentDto shipmentDto);

    /**
     * Update an existing shipment.
     *
     * @param shipmentDto the data transfer object with updated shipment details
     * @return the ID of the updated shipment
     */
    Long update(ShipmentDto shipmentDto);

    /**
     * Delete a shipment by its ID.
     *
     * @param id the ID of the shipment to delete
     */
    void delete(Long id);
}
