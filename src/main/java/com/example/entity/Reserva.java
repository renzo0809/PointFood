package com.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long number;

    @JoinColumn(name="mesa_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Mesa mesa;

    @JoinColumn(name="orden_id")
    @OneToOne(fetch = FetchType.LAZY)
    Orden orden;

    private String state;
}
