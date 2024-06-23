package com.proyectojava.tripulationroles.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.tripulationroles.domain.models.Tripulationroles;

public interface TripulationrolesRepository {
    void save(Tripulationroles tripulationroles);
    void update(Tripulationroles tripulationroles);
    Optional<Tripulationroles>findById(int id_rol);
    void delete(int id_rol);
    List<Tripulationroles> findAll();

}
