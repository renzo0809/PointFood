package com.example.service.Impl;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Restaurant;
import com.example.repository.RestaurantRepository;
import com.example.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Restaurant> getAllRestaurantsByRestaurantOwnerId(Long id) {
        return restaurantRepository.findRestaurantsByRestaurantOwner(id);
    }

    @Transactional
    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Restaurant restaurantDB= restaurantRepository.getOne(restaurant.getId());
        if(restaurantDB==null){
            return null;
        }
        restaurantDB.setAddress(restaurant.getAddress());
        restaurantDB.setDishes(restaurant.getDishes());
        restaurantDB.setExtras(restaurant.getExtras());
        restaurantDB.setName(restaurant.getName());
        restaurantDB.setPhone(restaurant.getPhone());
        restaurantDB.setRestaurantOwner(restaurant.getRestaurantOwner());
        return restaurantRepository.save(restaurantDB);
    }

    @Override
    public Restaurant deleteRestaurant(Restaurant restaurant) {
        return null;
    }
}
