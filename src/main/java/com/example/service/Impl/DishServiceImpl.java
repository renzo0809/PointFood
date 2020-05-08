package com.example.service.Impl;

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

    @Transactional(readOnly = true)
    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }
}
