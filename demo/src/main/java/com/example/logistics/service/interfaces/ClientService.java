package com.example.logistics.service.interfaces;

import com.example.logistics.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto getClientById(Long id);
    List<ClientDto> getAllClients();
    Long createClient(ClientDto clientDto);
    Boolean updateClient(Long id, ClientDto clientDto);
    void deleteClient(Long id);
}
