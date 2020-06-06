package com.example.controller;

import com.example.model.Card;
import com.example.model.Client;
import com.example.model.Dish;
import com.example.repository.DishRepository;
import com.example.service.DishService;
import com.example.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping(value = {"/restaurants/{id}"})
    public ResponseEntity<List<Dish>>listAllDishRestaurants(@PathVariable("id") Long id){
        List<Dish> dish = dishService.getDishByRestaurantId(id);
        if (dish.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dish);
    }

    @PostMapping
    public ResponseEntity<Dish> createDish(@Valid @RequestBody Dish dish, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Dish dishDB = dishService.createDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(dishDB);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<?> updateDish(@PathVariable("id") long id,@RequestBody Dish dish){
        dish.setId(id);
        Dish currentDish = dishService.updateDish(id, dish);
        if(currentDish==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currentDish);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> listAllDishes(){
        List<Dish>dishes=dishService.getAllDishes();
        if(dishes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dishes);
    }
}
