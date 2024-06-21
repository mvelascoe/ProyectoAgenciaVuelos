package com.proyectojava.airline.domain.models;

public class Airline {
    private int id_aerolinea;
    private String nombre_aerolinea; 

    public Airline() {
    }

    public Airline(int id_aerolinea, String nombre_aerolinea) {
        this.id_aerolinea = id_aerolinea;
        this.nombre_aerolinea = nombre_aerolinea;
    }


    //GETTERS AND SETTERS
    public int getId_aerolinea() {
        return id_aerolinea;
    }

    public void setId_aerolinea(int id_aerolinea) {
        this.id_aerolinea = id_aerolinea;
    }

    public String getNombre_aerolinea() {
        return nombre_aerolinea;
    }

    public void setNombre_aerolinea(String nombre_aerolinea) {
        this.nombre_aerolinea = nombre_aerolinea;
    }

    
}
