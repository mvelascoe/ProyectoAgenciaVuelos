package com.proyectojava.airport.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.domain.models.Airport;

public interface AirportRepository {
    void save(Airport airport);
    void update(Airport airport);
    Optional<Airport> findById(String id_aeropuerto);
    void delete(String id_aeropuerto);
    List<Airport> findAll();
}
