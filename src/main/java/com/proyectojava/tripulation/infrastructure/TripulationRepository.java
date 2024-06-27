package com.proyectojava.tripulation.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.tripulation.domain.models.Tripulation;

public interface TripulationRepository {
    void save(Tripulation tripulation);
    void update(Tripulation tripulation);
    Optional<Tripulation>findById(int id_tripulacion);
    void delete (int id_tripulacion);
    List<Tripulation>findAll();
}
