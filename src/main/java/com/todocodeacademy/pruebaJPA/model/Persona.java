package com.todocodeacademy.pruebaJPA.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "mascota_id_mascota", referencedColumnName = "id_mascota")
    private Mascota mascota;

    public Persona() {
    }

    public Persona(String name, String apellido, int edad, Long id) {
        this.nombre = name;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
    }
}
