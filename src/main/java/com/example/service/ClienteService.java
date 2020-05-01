package com.example.service;

import com.example.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listAllClientes();

    Cliente getCliente(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
    void deleteCliente(Long id);
}
