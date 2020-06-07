package com.example.service;

import com.example.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> findAllOrderDetailByOrderId(Long id);
}
