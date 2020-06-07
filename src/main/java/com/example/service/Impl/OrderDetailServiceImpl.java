package com.example.service.Impl;

import com.example.model.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Transactional
    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Transactional
    @Override
    public List<OrderDetail> findAllOrderDetailByOrderId(Long id) {
        return orderDetailRepository.getAllByOrderId(id);
    }
}
