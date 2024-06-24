package com.proyectojava.flightfare.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightfare.domain.models.Flightfare;

public interface FlightfareRepository {
    void save(Flightfare flightfare);
    void update(Flightfare flightfare);
    Optional<Flightfare> findById(int id_tarifa);
    void delete(int id_tarifa);
    List<Flightfare> findAll();
}
