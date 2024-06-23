package com.proyectojava.plane.domain.models;

import java.sql.Date;

public class Plane {
    private int id_avion;
    private String matricula;
    private int capacidad;
    private Date fecha_fabricacion;
    private int id_estado;
    private int id_modelo;

    public Plane() {
    }

    public Plane(int id_avion, String matricula, int capacidad, Date fecha_fabricacion, int id_estado, int id_modelo) {
        this.id_avion = id_avion;
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.fecha_fabricacion = fecha_fabricacion;
        this.id_estado = id_estado;
        this.id_modelo = id_modelo;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Date getFecha_fabricacion() {
        return fecha_fabricacion;
    }

    public void setFecha_fabricacion(Date fecha_fabricacion) {
        this.fecha_fabricacion = fecha_fabricacion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    

    
}
