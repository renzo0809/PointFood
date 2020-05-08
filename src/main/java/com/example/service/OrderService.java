package com.example.service;

import com.example.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    Order updateOrderState(Long id, String order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    List<Order> getAllOrdersByState(String state);
}
