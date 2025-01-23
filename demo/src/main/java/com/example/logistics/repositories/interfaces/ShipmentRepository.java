package com.example.logistics.repositories.interfaces;

import com.example.logistics.models.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
