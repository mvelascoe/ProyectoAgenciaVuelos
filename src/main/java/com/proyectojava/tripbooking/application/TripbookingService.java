package com.proyectojava.tripbooking.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.trip.infrastructure.TripRepository;
import com.proyectojava.tripbooking.domain.models.Tripbooking;
import com.proyectojava.tripbooking.infrastructure.TripbookingRepository;

public class TripbookingService {
    private final TripbookingRepository tripbookingRepository;
    private final TripRepository tripRepository;

    public TripbookingService(TripbookingRepository tripbookingRepository, TripRepository tripRepository) {
        this.tripbookingRepository = tripbookingRepository;
        this.tripRepository = tripRepository;
    }

    public void createTripbooking(Tripbooking tripbooking) {
        tripbookingRepository.save(tripbooking);
    }

    public void updateTripbooking(Tripbooking tripbooking) {
        tripbookingRepository.update(tripbooking);
    }

    public Optional<Tripbooking> getTripbookingById(int id_trip_booking) {
        return tripbookingRepository.findById(id_trip_booking);
    }

    public void deleteTripbooking(int id_trip_booking) {
        tripbookingRepository.delete(id_trip_booking);
    }

    public List<Tripbooking> getAllTripbooking() {
        return tripbookingRepository.findAll();
    }

    //TRAER METODOS DEL TRIP
    public Optional<Trip>findTrip(int id_trip){
        return tripRepository.findById(id_trip);
    }

    public List<Trip> AllTrips(){
        return tripRepository.findAll();
    }
    
} 

