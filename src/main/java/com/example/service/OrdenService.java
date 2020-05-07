package com.example.service;

import com.example.model.Order;

import java.util.List;

public interface OrdenService {

    List<Order> listAllOrden();

    Order getOrden(Long id);
    Order createOrden(Order order);
    Order updateOrden(Order order);
    void deleteOrden(Long id);

}
