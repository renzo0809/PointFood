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
    OrderRepository orderRepository;

    @Override
    public List<Order> listAllOrden() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrden(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrden(Order order) {
        order.setRegistrationTime(new Date());
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrden(Order order) {
       Order orderDB = this.getOrden(order.getId());
       if(orderDB ==null)
       {
            return null;
       }
       orderDB.setOrderTime(order.getOrderTime());
       orderDB.setPlatos(order.getPlatos());
       double price= 0.0;
        for (int i = 0; i < order.getPlatos().size(); i++) {
            for (int j = 0; j < order.getPlatos().get(i).getInsumos().size(); j++) {
                price=price+ order.getPlatos().get(i).getInsumos().get(j).getPrice();
            }
            price=price+ order.getPlatos().get(i).getPrice();
        }
        orderDB.setPrice(price);
        return orderRepository.save(orderDB);
    }

    @Override
    public void deleteOrden(Long id) {
        orderRepository.deleteById(id);
    }
}
