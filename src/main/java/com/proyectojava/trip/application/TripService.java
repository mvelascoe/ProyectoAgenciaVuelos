package com.proyectojava.trip.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.trip.infrastructure.TripRepository;
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
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
} 
