package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date registrationTime;
    private Date orderTime;
    private double price;

    @JoinColumn(name="cliente_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name="ordenes_platos",
            joinColumns = {@JoinColumn(name="orden_id")},
            inverseJoinColumns = {@JoinColumn(name="plato_id")})
    private List<Plato> platos=new ArrayList<>();


}
