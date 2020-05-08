package com.example.service.Impl;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order updateOrderState(String order) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getOrderById(Long id) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersByState(String state) {
        return null;
    }
}
