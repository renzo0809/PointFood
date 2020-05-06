package com.example.service.Impl;

import com.example.entity.Insumo;
import com.example.repository.InsumoRepository;
import com.example.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoServiceImpl implements InsumoService {
    @Autowired
    InsumoRepository InsumoRepository;

    @Override
    public List<Insumo> listAllInsumos() {
        return InsumoRepository.findAll();
    }

    @Override
    public Insumo getInsumo(Long id) {
        return InsumoRepository.findById(id).orElse(null);
    }

    @Override
    public Insumo createInsumo(Insumo Insumo) {
        return InsumoRepository.save(Insumo);
    }

    @Override
    public Insumo updateInsumo(Insumo Insumo) {
        Optional<Insumo> InsumoDB=InsumoRepository.findById(Insumo.getId());
        if(!InsumoDB.isPresent()){
            return null;
        }
        InsumoDB.get().setId(Insumo.getId());
        InsumoDB.get().setName(Insumo.getName());
        InsumoDB.get().setPrice(Insumo.getPrice());
        InsumoDB.get().setQuantity(Insumo.getQuantity());
        InsumoDB.get().setPlatos(Insumo.getPlatos());
        return InsumoRepository.save(InsumoDB.get());
    }

    @Override
    public void deleteInsumo(Long id) {
        InsumoRepository.deleteById(id);
    }
}
