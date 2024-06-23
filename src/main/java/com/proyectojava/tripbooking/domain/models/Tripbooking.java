package com.proyectojava.tripbooking.domain.models;

import java.sql.Date;

public class Tripbooking {
    private int id_trip_booking;
    private Date fecha_ticket;
    private int id_trip;


    public Tripbooking(){
    }

    
    public Tripbooking(int id_trip_booking, Date fecha_ticket, int id_trip) {
        this.id_trip_booking = id_trip_booking;
        this.fecha_ticket = fecha_ticket;
        this.id_trip = id_trip;
    }


    public int getId_trip_booking() {
        return id_trip_booking;
    }


    public void setId_trip_booking(int id_trip_booking) {
        this.id_trip_booking = id_trip_booking;
    }


    public Date getFecha_ticket() {
        return fecha_ticket;
    }


    public void setFecha_ticket(Date fecha_ticket) {
        this.fecha_ticket = fecha_ticket;
    }


    public int getId_trip() {
        return id_trip;
    }


    public void setId_trip(int id_trip) {
        this.id_trip = id_trip;
    }


}
