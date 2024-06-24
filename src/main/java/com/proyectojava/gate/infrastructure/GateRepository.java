package com.proyectojava.gate.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.gate.domain.models.Gate;

public interface GateRepository {
    void save (Gate gate);
    void update (Gate gate);
    Optional<Gate>findById(int id_puerta);
    void delete(int id_puerta);
    List<Gate>findAll();
}
