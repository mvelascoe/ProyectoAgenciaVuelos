package com.proyectojava.tripbookingdetails.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.tripbookingdetails.domain.models.TripBokkingDetails;

public interface TripBookkingDetailsRepository {
    void save(TripBokkingDetails tripBokkingDetails);
    void update(TripBokkingDetails tripBokkingDetails);
    Optional<TripBokkingDetails> findById(int id_trip_booking_details);
    void delete(int id_trip_booking_details);
    List<TripBokkingDetails>findAll();
}
