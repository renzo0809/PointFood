package com.example.service;

import com.example.entity.Reserva;

import java.util.List;

public interface ReservaService {
    List<Reserva> listAllReservas();

    Reserva getReserva(Long id);
    Reserva createReserva(Reserva Reserva);
    Reserva updateReserva(Reserva Reserva);
    void deleteReserva(Long id);
}
