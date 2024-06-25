package com.proyectojava.flightconnection.domain.models;

public class FlightConnection {
    private int id_trayectoria;
    private String trayectoria_numero;
    private int id_trip;
    private int id_avion;
    private String id_aeropuerto;

    public FlightConnection() {
    }

    public FlightConnection(int id_trayectoria, String trayectoria_numero, int id_trip, int id_avion,
            String id_aeropuerto) {
        this.id_trayectoria = id_trayectoria;
        this.trayectoria_numero = trayectoria_numero;
        this.id_trip = id_trip;
        this.id_avion = id_avion;
        this.id_aeropuerto = id_aeropuerto;
    }

    
    public FlightConnection(String trayectoria_numero, int id_trip, int id_avion, String id_aeropuerto) {
        this.trayectoria_numero = trayectoria_numero;
        this.id_trip = id_trip;
        this.id_avion = id_avion;
        this.id_aeropuerto = id_aeropuerto;
    }

    //GETTERS AND SETTERS
    public int getId_trayectoria() {
        return id_trayectoria;
    }

    public void setId_trayectoria(int id_trayectoria) {
        this.id_trayectoria = id_trayectoria;
    }

    public String getTrayectoria_numero() {
        return trayectoria_numero;
    }

    public void setTrayectoria_numero(String trayectoria_numero) {
        this.trayectoria_numero = trayectoria_numero;
    }

    public int getId_trip() {
        return id_trip;
    }

    public void setId_trip(int id_trip) {
        this.id_trip = id_trip;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public String getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(String id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }

    
    
}
