package com.proyectojava.flightconnection.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.airport.infrastructure.AirportRepository;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository;
import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.plane.infrastructure.PlaneRepository;
import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.trip.infrastructure.TripRepository;

public class FlightConnectionService {
    private final FlightConnectionRepository flightConnectionRepository;
    private final TripRepository tripRepository;
    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;

    public FlightConnectionService(FlightConnectionRepository flightConnectionRepository, TripRepository tripRepository,
            PlaneRepository planeRepository, AirportRepository airportRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
        this.airportRepository = airportRepository;
        this.planeRepository = planeRepository;
        this.tripRepository = tripRepository;
    }

    public void createConnection(FlightConnection flightConnection) {
        flightConnectionRepository.save(flightConnection);
    }

    public void updateConnecttion(FlightConnection flightConnection) {
        flightConnectionRepository.update(flightConnection);
    }

    public Optional<FlightConnection> findConnecttionById(int id_trayectoria) {
        return flightConnectionRepository.findById(id_trayectoria);
    }

    public void deleteConnecttion(int id_trayectoria) {
        flightConnectionRepository.delete(id_trayectoria);
    }

    public List<FlightConnection> findAllConnecttions() {
        return flightConnectionRepository.findAll();
    }

    // Metodos del Trip

    public void updateTrip(Trip trip) {
        tripRepository.update(trip);
    }

    public Optional<Trip> getTripById(int id_trip) {
        return tripRepository.findById(id_trip);
    }

    public List<Trip> getAllTripes() {
        return tripRepository.findAll();
    }

    // Metodos de plane

    public void updatePlane(Plane plane) {
        planeRepository.update(plane);
    }

    public Optional<Plane> getPlaneById(int id_avion) {
        return planeRepository.findById(id_avion);
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    // Metodos de airport

    public void updateAirport(Airport airport) {
        airportRepository.update(airport);
    }

    public Optional<Airport> findAirportById(String id_aeropuerto) {
        return airportRepository.findById(id_aeropuerto);
    }

    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }
}
