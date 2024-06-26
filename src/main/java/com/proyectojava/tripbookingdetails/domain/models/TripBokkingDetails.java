package com.proyectojava.tripbookingdetails.domain.models;

public class TripBokkingDetails {
    private int id_trip_booking_details;
    private int id_trip_booking;
    private String id_cliente;
    private int id_tarifa;

    public TripBokkingDetails() {
    }

    public TripBokkingDetails(int id_trip_booking_details, int id_trip_booking, String id_cliente, int id_tarifa) {
        this.id_trip_booking_details = id_trip_booking_details;
        this.id_trip_booking = id_trip_booking;
        this.id_cliente = id_cliente;
        this.id_tarifa = id_tarifa;
    }

    
    public TripBokkingDetails(int id_trip_booking, String id_cliente, int id_tarifa) {
        this.id_trip_booking = id_trip_booking;
        this.id_cliente = id_cliente;
        this.id_tarifa = id_tarifa;
    }

    public int getId_trip_booking_details() {
        return id_trip_booking_details;
    }

    public void setId_trip_booking_details(int id_trip_booking_details) {
        this.id_trip_booking_details = id_trip_booking_details;
    }

    public int getId_trip_booking() {
        return id_trip_booking;
    }

    public void setId_trip_booking(int id_trip_booking) {
        this.id_trip_booking = id_trip_booking;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    
    
}
