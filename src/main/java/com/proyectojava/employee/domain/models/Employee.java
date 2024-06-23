package com.proyectojava.employee.domain.models;

import java.sql.Date;

public class Employee {
    private String id_empleado;
    private String nombre_empleado;
    private int id_rol;
    private Date fecha_ingreso;
    private int id_aerolinea;
    private String id_aeropuerto;

    public Employee(String id_empleado, String nombre_empleado, int id_rol, Date fecha_ingreso, int id_aerolinea,
            String id_aeropuerto) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.id_rol = id_rol;
        this.fecha_ingreso = fecha_ingreso;
        this.id_aerolinea = id_aerolinea;
        this.id_aeropuerto = id_aeropuerto;
    }


    //GETTERS AND SETTERS
    
    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_aerolinea() {
        return id_aerolinea;
    }

    public void setId_aerolinea(int id_aerolinea) {
        this.id_aerolinea = id_aerolinea;
    }

    public String getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(String id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }

    
    
}
