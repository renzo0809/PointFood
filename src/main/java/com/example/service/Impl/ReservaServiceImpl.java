package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    ReservaRepository ReservaRepository;

    @Override
    public List<Reservation> listAllReservas() {
        return ReservaRepository.findAll();
    }

    @Override
    public Reservation getReserva(Long id) {
        return ReservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation createReserva(Reservation Reservation) {
        return ReservaRepository.save(Reservation);
    }

    @Override
    public Reservation updateReserva(Reservation Reservation) {
        Optional<Reservation> ReservaDB=ReservaRepository.findById(Reservation.getId());
        if(!ReservaDB.isPresent()){
            return null;
        }
        ReservaDB.get().setId(Reservation.getId());
        ReservaDB.get().setMesa(Reservation.getMesa());
        ReservaDB.get().setNumber(Reservation.getNumber());
        ReservaDB.get().setOrden(Reservation.getOrden());
        ReservaDB.get().setState(Reservation.getState());
        return ReservaRepository.save(ReservaDB.get());
    }

    @Override
    public void deleteReserva(Long id) {
        ReservaRepository.deleteById(id);
    }
}
