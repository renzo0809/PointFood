package com.example.service.Impl;

import com.example.entity.Restaurante;
import com.example.repository.RestauranteRepository;
import com.example.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    RestauranteRepository RestauranteRepository;

    @Override
    public List<Restaurante> listAllRestaurantes() {
        return RestauranteRepository.findAll();
    }

    @Override
    public Restaurante getRestaurante(Long id) {
        return RestauranteRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurante createRestaurante(Restaurante Restaurante) {
        return RestauranteRepository.save(Restaurante);
    }

    @Override
    public Restaurante updateRestaurante(Restaurante Restaurante) {
        Optional<Restaurante> RestauranteDB=RestauranteRepository.findById(Restaurante.getId());
        if(!RestauranteDB.isPresent()){
            return null;
        }
        RestauranteDB.get().setId(Restaurante.getId());
        RestauranteDB.get().setName(Restaurante.getName());
        RestauranteDB.get().setDueño(Restaurante.getDueño());
        return RestauranteRepository.save(RestauranteDB.get());
    }

    @Override
    public void deleteRestaurante(Long id) {
        RestauranteRepository.deleteById(id);
    }
}
