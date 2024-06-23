package com.proyectojava.gate.domain.models;

public class Gate {
    private int id_puerta;
    private int numero_puerta;
    private String id_aeropuerto;

    public Gate() {
    }

    public Gate(int id_puerta, int numero_puerta, String id_aeropuerto) {
        this.id_puerta = id_puerta;
        this.numero_puerta = numero_puerta;
        this.id_aeropuerto = id_aeropuerto;
    }

    public int getId_puerta() {
        return id_puerta;
    }

    public void setId_puerta(int id_puerta) {
        this.id_puerta = id_puerta;
    }

    public int getNumero_puerta() {
        return numero_puerta;
    }

    public void setNumero_puerta(int numero_puerta) {
        this.numero_puerta = numero_puerta;
    }

    public String getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(String id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }
   
}
