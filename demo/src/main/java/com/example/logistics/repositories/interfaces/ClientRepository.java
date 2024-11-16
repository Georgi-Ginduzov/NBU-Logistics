package com.example.logistics.repositories.interfaces;

import com.example.logistics.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
