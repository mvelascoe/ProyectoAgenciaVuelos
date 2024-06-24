package com.proyectojava.gate.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.gate.domain.models.Gate;
import com.proyectojava.gate.infrastructure.GateRepository;

public class GateService {
 private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public void createGate(Gate gate) {
        gateRepository.save(gate);
    }

    public void updateGate(Gate gate) {
        gateRepository.update(gate);
    }

    public Optional<Gate> getGateById(int id_puerta) {
        return gateRepository.findById(id_puerta);
    }

    public void deleteGate(int id_puerta) {
        gateRepository.delete(id_puerta);
    }

    public List<Gate> getAllGates() {
        return gateRepository.findAll();
    }
}
