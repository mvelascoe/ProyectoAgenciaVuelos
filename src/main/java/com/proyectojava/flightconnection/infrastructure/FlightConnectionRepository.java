package com.proyectojava.flightconnection.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightconnection.domain.models.Flightfare;

public interface FlightConnectionRepository {
    void save(Flightfare flightConnection);
    void update(Flightfare flightConnection);
    Optional<Flightfare> findById(int id_trayectoria);
    void delete(int id_trayectoria);
    List<Flightfare> findAll();
}
