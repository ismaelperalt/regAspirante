package com.example.Aspirante.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int numeroDeEstudiantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeEstudiantes() {
        return numeroDeEstudiantes;
    }

    public void setNumeroDeEstudiantes(int numeroDeEstudiantes) {
        this.numeroDeEstudiantes = numeroDeEstudiantes;
    }
}
