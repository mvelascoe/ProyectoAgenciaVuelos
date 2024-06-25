package com.proyectojava.flightconnection.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightconnection.domain.models.FlightConnection;

public interface FlightConnectionRepository {
    void save(FlightConnection flightConnection);
    void update(FlightConnection flightConnection);
    Optional<FlightConnection> findById(int id_trayectoria);
    void delete(int id_trayectoria);
    List<FlightConnection> findAll();
}
