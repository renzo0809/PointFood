package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tarjetas")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long number;
    @JoinColumn(name="cliente_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Cliente cliente;
}
