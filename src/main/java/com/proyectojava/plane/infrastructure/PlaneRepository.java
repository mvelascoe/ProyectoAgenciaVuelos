package com.proyectojava.plane.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.plane.domain.models.Plane;

public interface PlaneRepository {
    void save (Plane plane);
    void update(Plane plane);
    Optional<Plane>findById(int id_avion);
    void delete(int id_avion);
    List<Plane>findAll();
    Optional<Plane>findMatricula(String matricula);
}
