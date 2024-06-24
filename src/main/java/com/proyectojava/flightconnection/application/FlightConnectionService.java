package com.proyectojava.flightconnection.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightconnection.domain.models.Flightfare;
import com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository;

public class FlightConnectionService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createFligthConnection(Flightfare flightConnection){
        flightConnectionRepository.save(flightConnection);
    }

    public void updateFlightConnection(Flightfare flightConnection){
        flightConnectionRepository.update(flightConnection);
    }

    public Optional<Flightfare>findFligthConnectionById(int id_trayectoria){
        return flightConnectionRepository.findById(id_trayectoria);
    }

    public void deleteFligthConnection(int id_trayectoria){
        flightConnectionRepository.delete(id_trayectoria);
    }

    public List<Flightfare> findAllFlightsConnection(){
        return flightConnectionRepository.findAll();
    }
}
