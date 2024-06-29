package com.proyectojava.flightdetails.application;

import com.proyectojava.flightdetails.domain.models.Pasajeros;
import com.proyectojava.flightdetails.infrastructure.PasajerosRepository;

import java.util.List;
import java.util.Optional;

public class PasajerosService {
    private final PasajerosRepository pasajerosRepository;

    public PasajerosService(PasajerosRepository pasajerosRepository) {
        this.pasajerosRepository = pasajerosRepository;
    }

    public void createPasajero(Pasajeros pasajero) {
        pasajerosRepository.save(pasajero);
    }

    public void updatePasajero(Pasajeros pasajero) {
        pasajerosRepository.update(pasajero);
    }

    public Optional<Pasajeros> getPasajeroById(int id) {
        return pasajerosRepository.findById(id);
    }

    public void deletePasajero(int id) {
        pasajerosRepository.delete(id);
    }

    public List<Pasajeros> getAllPasajeros() {
        return pasajerosRepository.findAll();
    }
}