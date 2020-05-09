package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"signed_up_at"}, allowGetters = true)
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser vacío")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull(message = "El DNI no puede ser vacío")
    @Size(min=8,max=8)
    @Column(name = "dni", unique = true,length = 8, nullable = false)
    private String dni;

    @NotNull(message = "El email no puede ser vacío")
    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @NotNull(message = "La fecha de nacimiento no puede ser vacío")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    private Date birthDate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "signed_up_at")
    private Date signedUpAt;

    @NotNull(message = "El nombre de usuario no puede ser vacío")
    @Column(name = "username", unique = true, length = 20, nullable = false)
    private String username;

    @NotNull(message = "La contraseña no puede ser vacío")
    @Column(name = "password", length = 8, nullable = false)
    private String password;

}
