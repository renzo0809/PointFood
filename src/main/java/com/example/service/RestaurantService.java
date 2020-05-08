package com.example.service;

import com.example.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurantsByRestaurantOwnerId(Long id);
}
