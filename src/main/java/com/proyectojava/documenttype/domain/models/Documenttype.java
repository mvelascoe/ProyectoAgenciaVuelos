package com.proyectojava.documenttype.domain.models;

public class Documenttype {
    private int id_documento;
    private String nombre_documento;


    public Documenttype(int id_documento, String nombre_documento) {
        this.id_documento = id_documento;
        this.nombre_documento = nombre_documento;
    }

        //GETTERS AND SETTERS

    public int getId_documento() {
        return id_documento;
    }


    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }


    public String getNombre_documento() {
        return nombre_documento;
    }


    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    
}
