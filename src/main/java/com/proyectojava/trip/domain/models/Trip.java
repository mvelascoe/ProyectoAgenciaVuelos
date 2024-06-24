package com.proyectojava.trip.domain.models;

public class Trip {

    private int id_trip;
    private double precio;
    private String lugar_ida;
    private String lugar_llegada;
    
    public Trip() {
    }

    public Trip(int id_trip, double precio, String lugar_ida, String lugar_llegada) {
        this.id_trip = id_trip;
        this.precio = precio;
        this.lugar_ida = lugar_ida;
        this.lugar_llegada = lugar_llegada;
    }

    public int getId_trip() {
        return id_trip;
    }

    public void setId_trip(int id_trip) {
        this.id_trip = id_trip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLugar_ida() {
        return lugar_ida;
    }

    public void setLugar_ida(String lugar_ida) {
        this.lugar_ida = lugar_ida;
    }

    public String getLugar_llegada() {
        return lugar_llegada;
    }

    public void setLugar_llegada(String lugar_llegada) {
        this.lugar_llegada = lugar_llegada;
    }

    
 

}
