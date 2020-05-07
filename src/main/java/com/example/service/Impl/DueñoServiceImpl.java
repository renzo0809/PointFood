package com.example.service.Impl;

import com.example.model.RestaurantOwner;
import com.example.repository.RestaurantOwnerRepository;
import com.example.service.DueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantOwnerServiceImpl implements DueñoService {

    @Autowired
    RestaurantOwnerRepository restaurantOwnerRepository;

    @Override
    public List<RestaurantOwner> listAllDueños() {
        return restaurantOwnerRepository.findAll();
    }

    @Override
    public RestaurantOwner getDueño(Long id) {
        return restaurantOwnerRepository.findById(id).orElse(null);
    }

    @Override
    public RestaurantOwner createDueño(RestaurantOwner RestaurantOwner) {
        return restaurantOwnerRepository.save(RestaurantOwner);
    }

    @Override
    public RestaurantOwner updateDueño(RestaurantOwner RestaurantOwner) {
        Optional<RestaurantOwner> dueñoDB= restaurantOwnerRepository.findById(RestaurantOwner.getId());
        if(!dueñoDB.isPresent()){
            return null;
        }
        dueñoDB.get().setId(RestaurantOwner.getId());
        dueñoDB.get().setDni(RestaurantOwner.getDni());
        dueñoDB.get().setEmail(RestaurantOwner.getEmail());
        dueñoDB.get().setName(RestaurantOwner.getName());
        return restaurantOwnerRepository.save(dueñoDB.get());
    }

    @Override
    public void deleteDueño(Long id) {
        restaurantOwnerRepository.deleteById(id);
    }
}
