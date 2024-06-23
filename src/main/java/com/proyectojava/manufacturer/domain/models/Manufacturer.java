package com.proyectojava.manufacturer.domain.models;

public class Manufacturer {
    private int id_manufactura;
    private String nombre_manufactura;
    
    public Manufacturer() {
    }

    public Manufacturer(int id_manufactura, String nombre_manufactura) {
        this.id_manufactura = id_manufactura;
        this.nombre_manufactura = nombre_manufactura;
    }

    public int getId_manufactura() {
        return id_manufactura;
    }

    public void setId_manufactura(int id_manufactura) {
        this.id_manufactura = id_manufactura;
    }

    public String getNombre_manufactura() {
        return nombre_manufactura;
    }

    public void setNombre_manufactura(String nombre_manufactura) {
        this.nombre_manufactura = nombre_manufactura;
    }


}
