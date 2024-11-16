package com.example.logistics.service;

import com.example.logistics.dto.ClientDto;
import com.example.logistics.entities.Client;
import com.example.logistics.exceptions.ResourceNotFoundException;
import com.example.logistics.repositories.interfaces.ClientRepository;
import com.example.logistics.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return convertToDto(client.get());
        } else {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setAddress(clientDto.getAddress());
        client.setPhoneNumber(clientDto.getPhoneNumber());

        Client savedClient = clientRepository.save(client);

        return savedClient.getId();
    }

    @Override
    public Boolean updateClient(Long id, ClientDto clientDto) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDto.getName());
            client.setAddress(clientDto.getAddress());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
    }

    private ClientDto convertToDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setAddress(client.getAddress());
        dto.setPhoneNumber(client.getPhoneNumber());
        return dto;
    }
}
