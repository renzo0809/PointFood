package com.example.service.Impl;

import com.example.entity.Plato;
import com.example.repository.PlatoRepository;
import com.example.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements PlatoService {
    @Autowired
    PlatoRepository PlatoRepository;

    @Override
    public List<Plato> listAllPlatos() {
        return PlatoRepository.findAll();
    }

    @Override
    public Plato getPlato(Long id) {
        return PlatoRepository.findById(id).orElse(null);
    }

    @Override
    public Plato createPlato(Plato Plato) {
        return PlatoRepository.save(Plato);
    }

    @Override
    public Plato updatePlato(Plato Plato) {
        Optional<Plato> PlatoDB=PlatoRepository.findById(Plato.getId());
        if(!PlatoDB.isPresent()){
            return null;
        }
        PlatoDB.get().setId(Plato.getId());
        PlatoDB.get().setDescription(Plato.getDescription());
        PlatoDB.get().setInsumos(Plato.getInsumos());
        PlatoDB.get().setName(Plato.getName());
        PlatoDB.get().setOrdenes(Plato.getOrdenes());
        PlatoDB.get().setPrice(Plato.getPrice());
        return PlatoRepository.save(PlatoDB.get());
    }

    @Override
    public void deletePlato(Long id) {
        PlatoRepository.deleteById(id);
    }
}
