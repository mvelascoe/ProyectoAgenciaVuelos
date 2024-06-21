package com.proyectojava.airline.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airline.domain.models.Airline;

public interface AirlineRepository {
    void save(Airline airline);
    void update(Airline airline);
    Optional<Airline> findById(int id_aerolinea);
    void delete(int id_aerolinea);
    List<Airline> findAll();
}
