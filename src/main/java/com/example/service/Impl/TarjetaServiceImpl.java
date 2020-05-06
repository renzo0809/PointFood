package com.example.service.Impl;

import com.example.entity.Tarjeta;
import com.example.repository.TarjetaRepository;
import com.example.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    TarjetaRepository TarjetaRepository;

    @Override
    public List<Tarjeta> listAllTarjetas() {
        return TarjetaRepository.findAll();
    }

    @Override
    public Tarjeta getTarjeta(Long id) {
        return TarjetaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarjeta createTarjeta(Tarjeta Tarjeta) {
        return TarjetaRepository.save(Tarjeta);
    }

    @Override
    public Tarjeta updateTarjeta(Tarjeta Tarjeta) {
        Optional<Tarjeta> TarjetaDB=TarjetaRepository.findById(Tarjeta.getId());
        if(!TarjetaDB.isPresent()){
            return null;
        }
        TarjetaDB.get().setId(Tarjeta.getId());
        TarjetaDB.get().setCliente(Tarjeta.getCliente());
        TarjetaDB.get().setNumber(Tarjeta.getNumber());
        return TarjetaRepository.save(TarjetaDB.get());
    }

    @Override
    public void deleteTarjeta(Long id) {
        TarjetaRepository.deleteById(id);
    }
}
