package com.example.Aspirante.Entity;

import jakarta.persistence.*;

@Entity
public class Aspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cedula;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "colegio_id", nullable = false)
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    private double valorInscripcion;

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public double getValorInscripcion() {
        return valorInscripcion;
    }

    public void setValorInscripcion(double valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }

}