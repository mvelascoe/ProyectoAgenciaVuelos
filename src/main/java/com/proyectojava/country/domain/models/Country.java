package com.proyectojava.country.domain.models;

public class Country {
    private String id_pais;
    private String nombre_pais;

    public Country(String id_pais, String nombre_pais) {
        this.id_pais = id_pais;
        this.nombre_pais = nombre_pais;
    }

    //GETTERS AND SETTERS
    
    public String getId_pais() {
        return id_pais;
    }


    public void setId_pais(String id_pais) {
        this.id_pais = id_pais;
    }


    public String getNombre_pais() {
        return nombre_pais;
    }


    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }


    

    


}
