package com.proyectojava.tripbooking.adapters.out;
import java.util.List;
import java.util.Optional;

import com.proyectojava.tripbooking.domain.models.Tripbooking;
import com.proyectojava.tripbooking.infrastructure.TripbookingRepository;

public class TripbookingMySQLRepository implements TripbookingRepository{

    @Override
    public void save(Tripbooking tripbooking) {

    }

    @Override
    public void update(Tripbooking Tripbooking) {

    }

    @Override
    public Optional<Tripbooking> findById(int id_trip_booking) {
        return null;

    }

    @Override
    public void delete(int id_trip_booking) {

    }

    @Override
    public List<Tripbooking> findAll() {
        return null;

    }

}
