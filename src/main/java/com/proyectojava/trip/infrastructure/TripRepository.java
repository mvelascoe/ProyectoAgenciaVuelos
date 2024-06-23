package com.proyectojava.trip.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.trip.domain.models.Trip;

public interface TripRepository {
    void save (Trip trip);
    void update (Trip trip);
    Optional<Trip> findById(int id_trip);
    void delete(int id_trip);
    List<Trip> findAll();
}
