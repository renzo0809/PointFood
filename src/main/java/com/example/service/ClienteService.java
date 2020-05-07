package com.example.service;

import com.example.model.Client;

import java.util.List;

public interface ClienteService {

    List<Client> listAllClientes();

    Client getCliente(Long id);
    Client createCliente(Client client);
    Client updateCliente(Client client);
    void deleteCliente(Long id);
}
