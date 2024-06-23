package com.proyectojava.tripbooking.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.tripbooking.domain.models.Tripbooking;

public interface TripbookingRepository {
    void save(Tripbooking tripbooking);
    void update(Tripbooking Tripbooking);
    Optional<Tripbooking> findById(int id_trip_booking);
    void delete(int id_trip_booking);
    List<Tripbooking> findAll();

}
