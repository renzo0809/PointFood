package com.example.service;

import com.example.model.Client;
import com.example.model.RestaurantOwner;

import java.util.List;

public interface RestaurantOwnerService {

    RestaurantOwner getRestaurantOwnerByUsernameAndPassword(String username, String password);
    RestaurantOwner updateRestaurantOwner(RestaurantOwner restaurantOwner);
    RestaurantOwner deleteRestaurantOwner(Long id);
}
