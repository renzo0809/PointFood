package com.example.service;

import com.example.model.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client getClientByUsernameAndPassword(String username, String password);
    Client updateClient(Client client);
    Client deleteClient(Long id);
}
