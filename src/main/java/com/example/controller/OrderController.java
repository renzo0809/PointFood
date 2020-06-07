package com.example.controller;

import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.service.OrderDetailService;
import com.example.service.OrderService;
import com.example.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Order orderDB = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDB);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id")Long id){
        Order order = orderService.getOrderById(id);
        if (null == order) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<?> getOrderDetails(@PathVariable("id")Long id){
        Order order = orderService.getOrderById(id);
        if (null == order) {
            return ResponseEntity.notFound().build();
        }
        List<OrderDetail> orderDetailsDB=orderDetailService.findAllOrderDetailByOrderId(id);
        if(orderDetailsDB.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(orderDetailsDB);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrderState(@PathVariable("id") Long id, @RequestBody Order order){
        Order orderDB = orderService.getOrderById(id);
        if (null == orderDB) {
            return ResponseEntity.notFound().build();
        }else{
            orderService.updateOrderState(id, order.getState().getName());
        }

        return ResponseEntity.ok(orderDB);
    }

    @GetMapping
    public ResponseEntity<List<Order>> listAllOrders(){
        List<Order> orders = new ArrayList<>();
        orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/states")
    public ResponseEntity<List<Order>> listAllOrdersByState(@RequestBody Order order){
        List<Order> orders = new ArrayList<>();
        orders = orderService.getAllOrdersByState(order.getState().getName());
        if(orders.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }
}
