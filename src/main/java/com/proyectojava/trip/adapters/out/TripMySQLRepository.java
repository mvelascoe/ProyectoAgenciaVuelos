package com.proyectojava.trip.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.trip.infrastructure.TripRepository;

public class TripMySQLRepository implements TripRepository{

    @Override
    public void save(Trip trip) {

    }

    @Override
    public void update(Trip trip) {

    }

    @Override
    public Optional<Trip> findById(int id_trip) {
        return null;

    }

    @Override
    public void delete(int id_trip) {

    }

    @Override
    public List<Trip> findAll() {
        return null;

    }

}
