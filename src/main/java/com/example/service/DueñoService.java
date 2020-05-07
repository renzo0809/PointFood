package com.example.service;

import com.example.model.RestaurantOwner;

import java.util.List;

public interface DueñoService {
    List<RestaurantOwner> listAllDueños();

    RestaurantOwner getDueño(Long id);
    RestaurantOwner createDueño(RestaurantOwner RestaurantOwner);
    RestaurantOwner updateDueño(RestaurantOwner RestaurantOwner);
    void deleteDueño(Long id);
}
