package com.proyectojava.trip.domain.models;

public class Trip {

    private int id_trip;
    private double precio;
    
    public Trip() {
    }

    public Trip(int id_trip, double precio) {
        this.id_trip = id_trip;
        this.precio = precio;
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
 

}
