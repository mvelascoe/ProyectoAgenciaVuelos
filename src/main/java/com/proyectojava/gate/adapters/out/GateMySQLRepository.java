package com.proyectojava.gate.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.gate.domain.models.Gate;
import com.proyectojava.gate.infrastructure.GateRepository;

public class GateMySQLRepository implements GateRepository {

    @Override
    public void save(Gate gate) {

    }

    @Override
    public void uptade(Gate gate) {

    }

    @Override
    public Optional<Gate> findById(int id_puerta) {
        return null;

    }

    @Override
    public void delete(int id_puerta) {

    }

    @Override
    public List<Gate> findAll() {
        return null;

    }

}
