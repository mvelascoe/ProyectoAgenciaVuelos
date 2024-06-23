package com.proyectojava.customer.domain.models;

public class Customer {
    private String id_cliente;
    private String nombre_cliente;
    private int edad_cliente;
    private int id_documento;

    public Customer(String id_cliente, String nombre_cliente, int edad_cliente, int id_documento) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.edad_cliente = edad_cliente;
        this.id_documento = id_documento;
    }


    //GETTERS AND SETTERS 
    
    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getEdad_cliente() {
        return edad_cliente;
    }

    public void setEdad_cliente(int edad_cliente) {
        this.edad_cliente = edad_cliente;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    
}
