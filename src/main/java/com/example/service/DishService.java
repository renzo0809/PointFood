package com.example.service;

import com.example.model.Dish;

import java.util.List;

public interface DishService {

    Dish createDish(Dish dish);
    List<Dish> getDishByRestaurantId(Long id);
    Dish updateDish(Long id, Dish dish);
    List<Dish> getAllDishes();
}
