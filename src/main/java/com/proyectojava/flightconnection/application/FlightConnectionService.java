package com.proyectojava.flightconnection.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository;

public class FlightConnectionService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createConnection(FlightConnection flightConnection){
        flightConnectionRepository.save(flightConnection);
    }

    public void updateConnecttion(FlightConnection flightConnection){
        flightConnectionRepository.update(flightConnection);
    }

    public Optional<FlightConnection> findConnecttionById(int id_trayectoria){
        return flightConnectionRepository.findById(id_trayectoria);
    }

    public void deleteConnecttion(int id_trayectoria){
        flightConnectionRepository.delete(id_trayectoria);
    }

    public List<FlightConnection> findAllConnecttions(){
        return flightConnectionRepository.findAll();
    }
}
