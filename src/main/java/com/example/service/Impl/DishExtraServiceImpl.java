package com.example.service.Impl;

import com.example.model.DishExtra;
import com.example.repository.DishExtraRepository;
import com.example.service.DishExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DishExtraServiceImpl implements DishExtraService {

    @Autowired
    private DishExtraRepository dishExtraRepository;

    @Transactional
    @Override
    public DishExtra createDishExtra(DishExtra dishExtra) {
        return dishExtraRepository.save(dishExtra);
    }
}
