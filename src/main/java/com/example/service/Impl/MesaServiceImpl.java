package com.example.service.Impl;

import com.example.entity.Mesa;
import com.example.repository.MesaRepository;
import com.example.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {
    @Autowired
    MesaRepository MesaRepository;

    @Override
    public List<Mesa> listAllMesas() {
        return MesaRepository.findAll();
    }

    @Override
    public Mesa getMesa(Long id) {
        return MesaRepository.findById(id).orElse(null);
    }

    @Override
    public Mesa createMesa(Mesa Mesa) {
        return MesaRepository.save(Mesa);
    }

    @Override
    public Mesa updateMesa(Mesa Mesa) {
        Optional<Mesa> MesaDB=MesaRepository.findById(Mesa.getId());
        if(!MesaDB.isPresent()){
            return null;
        }
        MesaDB.get().setId(Mesa.getId());
        MesaDB.get().setNumber(Mesa.getNumber());
        MesaDB.get().setId(Mesa.getId());
        return MesaRepository.save(MesaDB.get());
    }

    @Override
    public void deleteMesa(Long id) {
        MesaRepository.deleteById(id);
    }
}
