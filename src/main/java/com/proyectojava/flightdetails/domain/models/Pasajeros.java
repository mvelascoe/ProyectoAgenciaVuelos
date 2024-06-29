package com.proyectojava.flightdetails.domain.models;

public class Pasajeros {
    private int id;
    private int id_trip;
    private String id_cliente;
    private int id_asiento;

    public Pasajeros() {
    }

    public Pasajeros(int id, int id_trip, String id_cliente, int id_asiento) {
        this.id = id;
        this.id_trip = id_trip;
        this.id_cliente = id_cliente;
        this.id_asiento = id_asiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_trip() {
        return id_trip;
    }

    public void setId_trip(int id_trip) {
        this.id_trip = id_trip;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }
}