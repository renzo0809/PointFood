package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name="dueño_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Dueño dueño;
}
