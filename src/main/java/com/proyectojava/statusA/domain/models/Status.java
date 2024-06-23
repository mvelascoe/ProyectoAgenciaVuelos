package com.proyectojava.statusA.domain.models;

public class Status {
    private int id_estado;
    private String nombre_estado;

    public Status() {
    }

    public Status(int id_estado, String nombre_estado) {
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

}
