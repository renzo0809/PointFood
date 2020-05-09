package com.example.service.Impl;

import com.example.exception.ResourceNotFoundException;
import com.example.model.DishExtra;
import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.repository.*;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ExtraRepository extraRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private DishExtraRepository dishExtraRepository;

    @Transactional
    @Override
    public Order createOrder(Order order) {

        order.setState("Pendiente");
        orderRepository.save(order);
        for (OrderDetail od : order.getDishes()){
            od.setOrder(order);
            orderDetailRepository.save(od);
            for(DishExtra ex : od.getExtras()){
                ex.setOrderDetail(od);
                dishExtraRepository.save(ex);
            }
        }

        CalculateSubTotalDishExtra(order.getDishes());
        CalculateSubTotalOrderDetail(order.getDishes());
        CalculateTotalOrder(order);
        return orderRepository.save(order);
    }

    public void CalculateSubTotalDishExtra(List<OrderDetail> dishes){
        for (OrderDetail od : dishes){
            for(DishExtra ex : od.getExtras()){
                ex.setSubTotal(
                        extraRepository.getOne(ex.getExtra().getId()).getPrice() *
                        ex.getQuantity()
                );
            }
        }
    }
    public void CalculateSubTotalOrderDetail(List<OrderDetail> dishes){
        for (OrderDetail od : dishes){
            od.setSubTotal(
                    od.getExtras().stream().mapToDouble(x -> x.getSubTotal()).sum() +
                    dishRepository.getOne(od.getDish().getId()).getPrice()
            );
        }
    }

    public void CalculateTotalOrder(Order order){
        order.setTotal(order.getDishes().stream().mapToDouble(x -> x.getSubTotal()).sum());
    }

    @Transactional
    @Override
    public Order updateOrderState(Long id, String order) {
        Order orderDB = orderRepository.getOne(id);
        if(orderDB == null){
            throw new ResourceNotFoundException("There is no order with Id " + id);
        }
        orderDB.setState(order);

        return orderRepository.save(orderDB);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getAllOrdersByState(String state) {
        return orderRepository.findAllByState(state);
    }
}
