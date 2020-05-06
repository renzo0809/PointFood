package com.example.service.Impl;

import com.example.entity.Reserva;
import com.example.repository.ReservaRepository;
import com.example.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    ReservaRepository ReservaRepository;

    @Override
    public List<Reserva> listAllReservas() {
        return ReservaRepository.findAll();
    }

    @Override
    public Reserva getReserva(Long id) {
        return ReservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva createReserva(Reserva Reserva) {
        return ReservaRepository.save(Reserva);
    }

    @Override
    public Reserva updateReserva(Reserva Reserva) {
        Optional<Reserva> ReservaDB=ReservaRepository.findById(Reserva.getId());
        if(!ReservaDB.isPresent()){
            return null;
        }
        ReservaDB.get().setId(Reserva.getId());
        ReservaDB.get().setMesa(Reserva.getMesa());
        ReservaDB.get().setNumber(Reserva.getNumber());
        ReservaDB.get().setOrden(Reserva.getOrden());
        ReservaDB.get().setState(Reserva.getState());
        return ReservaRepository.save(ReservaDB.get());
    }

    @Override
    public void deleteReserva(Long id) {
        ReservaRepository.deleteById(id);
    }
}
