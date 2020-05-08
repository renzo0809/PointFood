package com.example.service;

import com.example.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    Order updateOrderState(String order);
    List<Order> getAllOrders();
    List<Order> getOrderById(Long id);
    List<Order> getAllOrdersByState(String state);
}
