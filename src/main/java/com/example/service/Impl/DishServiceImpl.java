package com.example.service.Impl;

import com.example.model.Dish;
import com.example.repository.DishRepository;
import com.example.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishRepository DishRepository;

    @Override
    public List<Dish> listAllPlatos() {
        return DishRepository.findAll();
    }

    @Override
    public Dish getPlato(Long id) {
        return DishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish createPlato(Dish Dish) {
        return DishRepository.save(Dish);
    }

    @Override
    public Dish updatePlato(Dish Dish) {
        Optional<Dish> PlatoDB= DishRepository.findById(Dish.getId());
        if(!PlatoDB.isPresent()){
            return null;
        }
        PlatoDB.get().setId(Dish.getId());
        PlatoDB.get().setDescription(Dish.getDescription());
        PlatoDB.get().setInsumos(Dish.getInsumos());
        PlatoDB.get().setName(Dish.getName());
        PlatoDB.get().setOrdenes(Dish.getOrdenes());
        PlatoDB.get().setPrice(Dish.getPrice());
        return DishRepository.save(PlatoDB.get());
    }

    @Override
    public void deletePlato(Long id) {
        DishRepository.deleteById(id);
    }
}
