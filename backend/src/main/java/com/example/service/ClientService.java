package com.example.service;

import com.example.repository.ClientRepository;
import com.example.model.Client;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository = new ClientRepository();

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}