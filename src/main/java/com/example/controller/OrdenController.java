package com.example.controller;


import com.example.model.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> listOrden()
    {
        List<Order> ordenes= orderService.listAllOrden();
        if(ordenes.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(ordenes);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrden(@PathVariable("id") Long id)
    {
        Order order = orderService.getOrden(id);
        if(order ==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrden(@Valid @RequestBody Order order,
                                             BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Order orderCreate = orderService.createOrden(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrden(@PathVariable Long id,
                                             @RequestBody Order order)
    {
        order.setId(id);
        Order orderDB = orderService.updateOrden(order);
        if(orderDB ==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDB);
    }

    @DeleteMapping
    public ResponseEntity<Order> deleteOrden(@PathVariable Long id)
    {
        Order orderDB = orderService.getOrden(id);
        if(orderDB ==null)
        {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteOrden(id);
        return ResponseEntity.ok(orderDB);

    }

}
