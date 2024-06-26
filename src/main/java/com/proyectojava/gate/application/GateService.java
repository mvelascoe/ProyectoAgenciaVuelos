package com.proyectojava.gate.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.airport.infrastructure.AirportRepository;
import com.proyectojava.gate.domain.models.Gate;
import com.proyectojava.gate.infrastructure.GateRepository;

public class GateService {
 private final GateRepository gateRepository;
 private final AirportRepository airportRepository;

    public GateService(GateRepository gateRepository, AirportRepository airportRepository) {
    this.gateRepository = gateRepository;
    this.airportRepository = airportRepository;
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

    //METODOS PARA OBTENER LOS AEROPUERTOS

    public List<Airport> findAllAirports(){
        return airportRepository.findAll();
    }

    public Optional<Airport> findAirport(String id_aeropuerto){
        return airportRepository.findById(id_aeropuerto);
    }

    public void updateAirport(Airport airport){
        airportRepository.update(airport);
    }
    
}
