package com.proyectojava.trip.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository;
import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.trip.infrastructure.TripRepository;
public class TripService {

    private final TripRepository tripRepository;
    private final FlightConnectionRepository flightConnectionRepository;

    public TripService(TripRepository tripRepository, FlightConnectionRepository flightConnectionRepository) {
        this.tripRepository = tripRepository;
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void updateTrip(Trip trip) {
        tripRepository.update(trip);
    }

    public Optional<Trip> getTripById(int id_trip) {
        return tripRepository.findById(id_trip);
    }

    public void deleteTrip(int id_trip) {
        tripRepository.delete(id_trip);
    }

    public List<Trip> getAllTripes() {
        return tripRepository.findAll();
    }

    //Metodos de FlightConnection

    public void createConnection(FlightConnection flightConnection) {
        flightConnectionRepository.save(flightConnection);
    }

    public void updateConnecttion(FlightConnection flightConnection) {
        flightConnectionRepository.update(flightConnection);
    }

    public Optional<FlightConnection> findConnecttionById(int id_trayectoria) {
        return flightConnectionRepository.findById(id_trayectoria);
    }

    public List<FlightConnection> findAllConnecttions() {
        return flightConnectionRepository.findAll();
    }
} 
