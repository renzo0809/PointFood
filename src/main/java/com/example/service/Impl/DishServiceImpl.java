package com.example.service.Impl;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Card;
import com.example.model.Dish;
import com.example.repository.DishRepository;
import com.example.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Transactional
    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Transactional
    @Override
    public Dish updateDish(Long id, Dish dish) {
        Dish dishDB = dishRepository.getOne(id);
        if(dishDB == null){
            throw new ResourceNotFoundException("There is not dish with Id " + id);
        }
        dishDB.setName(dish.getName());
        dishDB.setPrice(dish.getPrice());

        return dishRepository.save(dishDB);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dish> getDishByRestaurantId(Long id)
    {
        return dishRepository.findDishByRestaurant(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }
}
