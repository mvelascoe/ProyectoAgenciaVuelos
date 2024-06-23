package com.proyectojava.tripulationroles.domain.models;

public class Tripulationroles {
    private int id_rol;
    private int nombre_rol;

    public Tripulationroles() {
    }
    
    public Tripulationroles(int id_rol, int nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(int nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    
}
