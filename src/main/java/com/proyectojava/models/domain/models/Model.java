package com.proyectojava.models.domain.models;

public class Model {
    private int id_modelo;
    private String nombre_modelo;
    private int id_manufactura;

    public Model() {
    }

    public Model(int id_modelo, String nombre_modelo, int id_manufactura) {
        this.id_modelo = id_modelo;
        this.nombre_modelo = nombre_modelo;
        this.id_manufactura = id_manufactura;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

    public int getId_manufactura() {
        return id_manufactura;
    }

    public void setId_manufactura(int id_manufactura) {
        this.id_manufactura = id_manufactura;
    } 

}
