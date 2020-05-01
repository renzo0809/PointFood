package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="platos")
public class Plato {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @ManyToMany(fetch=FetchType.LAZY,
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                })
    @JoinTable(name="platos_insumos",
                joinColumns = {@JoinColumn(name="plato_id")},
                inverseJoinColumns = {@JoinColumn(name="insumo_id")})
    private List<Insumo> insumos=new ArrayList<>();


}
