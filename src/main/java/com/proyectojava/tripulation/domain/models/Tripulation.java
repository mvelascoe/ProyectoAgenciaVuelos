package com.proyectojava.tripulation.domain.models;

public class Tripulation {
    private int id_tripulacion;
    private String id_empleado;
    private int id_trayectoria;
    
    public Tripulation() {
    }

    public Tripulation(int id_tripulacion, String id_empleado, int id_trayectoria) {
        this.id_tripulacion = id_tripulacion;
        this.id_empleado = id_empleado;
        this.id_trayectoria = id_trayectoria;
    }

    public Tripulation(String id_empleado, int id_trayectoria) {
        this.id_empleado = id_empleado;
        this.id_trayectoria = id_trayectoria;
    }

    //GETTERS AND SETTERS

    public int getId_tripulacion() {
        return id_tripulacion;
    }

    public void setId_tripulacion(int id_tripulacion) {
        this.id_tripulacion = id_tripulacion;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_trayectoria() {
        return id_trayectoria;
    }

    public void setId_trayectoria(int id_trayectoria) {
        this.id_trayectoria = id_trayectoria;
    }

    
}
