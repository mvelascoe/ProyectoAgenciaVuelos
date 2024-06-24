package com.proyectojava.flightfare.domain.models;

public class Flightfare {
    private int id_tarifa;
    private String descripcion;
    private String detalles;
    private double valor;
    
    public Flightfare() {
    }

    public Flightfare(int id_tarifa, String descripcion, String detalles, double valor) {
        this.id_tarifa = id_tarifa;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.valor = valor;
    }

    
    public Flightfare(String descripcion, String detalles, double valor) {
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.valor = valor;
    }

    //GETTERS AND SETTERS
    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
