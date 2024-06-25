package com.proyectojava.cities.domain.models;

public class Cities {
    private String id_ciudad;
    private String nombre_ciudad;
    private String id_pais;


    public Cities(String id_ciudad, String nombre_ciudad, String id_pais) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
        this.id_pais = id_pais;
    }


    //GETTERS AND SETTERS
    
    public String getId_ciudad() {
        return id_ciudad;
    }


    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }


    public String getNombre_ciudad() {
        return nombre_ciudad;
    }


    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }


    public String getId_pais() {
        return id_pais;
    }


    public void setId_pais(String id_pais) {
        this.id_pais = id_pais;
    }


    public void ifPresentOrElse(Object object, Object object2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ifPresentOrElse'");
    }

    
    
}
