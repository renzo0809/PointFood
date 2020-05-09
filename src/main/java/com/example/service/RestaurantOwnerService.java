package com.example.service;

import com.example.model.Client;
import com.example.model.Restaurant;
import com.example.model.RestaurantOwner;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantOwnerService {

    RestaurantOwner getRestaurantOwnerByUsernameAndPassword(String username, String password);
    RestaurantOwner updateRestaurantOwner(Long id, RestaurantOwner restaurantOwner);
    RestaurantOwner deleteRestaurantOwner(Long id);
}
