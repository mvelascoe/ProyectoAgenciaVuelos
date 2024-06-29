package com.proyectojava.flightdetails.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightdetails.domain.models.Pasajeros;

public interface PasajerosRepository {
    void save(Pasajeros pasajero);
    void update(Pasajeros pasajero);
    Optional<Pasajeros> findById(int id);
    void delete(int id);
    List<Pasajeros> findAll();
}
