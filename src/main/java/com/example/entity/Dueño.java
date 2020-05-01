package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="dueños")
public class Dueño {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="El nombre no debe estar vacio")
    private String name;

    @Size(min=8,max=8)
    @Column(unique = true,length = 8,nullable = false)
    private String dni;
    @NotEmpty(message = "El correo no debe estar vacio")
    private String email;
}
