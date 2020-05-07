package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {
    @Autowired
    MesaRepository MesaRepository;

    @Override
    public List<Table> listAllMesas() {
        return MesaRepository.findAll();
    }

    @Override
    public Table getMesa(Long id) {
        return MesaRepository.findById(id).orElse(null);
    }

    @Override
    public Table createMesa(Table Table) {
        return MesaRepository.save(Table);
    }

    @Override
    public Table updateMesa(Table Table) {
        Optional<Table> MesaDB=MesaRepository.findById(Table.getId());
        if(!MesaDB.isPresent()){
            return null;
        }
        MesaDB.get().setId(Table.getId());
        MesaDB.get().setNumber(Table.getNumber());
        MesaDB.get().setId(Table.getId());
        return MesaRepository.save(MesaDB.get());
    }

    @Override
    public void deleteMesa(Long id) {
        MesaRepository.deleteById(id);
    }
}
