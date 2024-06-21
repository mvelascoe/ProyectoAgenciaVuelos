package com.proyectojava.airport.domain.models;

public class Airport {
    private String id_aeropuerto;
    private String nombre_aeropuerto;
    private String id_ciudad;

    public Airport(){

    }

    public Airport(String id_aeropuerto, String nombre_aeropuerto, String id_ciudad) {
        this.id_aeropuerto = id_aeropuerto;
        this.nombre_aeropuerto = nombre_aeropuerto;
        this.id_ciudad = id_ciudad;
    }

    public String getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(String id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }

    public String getNombre_aeropuerto() {
        return nombre_aeropuerto;
    }

    public void setNombre_aeropuerto(String nombre_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
    }

    public String getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }


    //GETTERS AND SETTERS
    

}
