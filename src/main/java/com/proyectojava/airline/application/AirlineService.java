package com.proyectojava.airline.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airline.domain.models.Airline;
import com.proyectojava.airline.infrastructure.AirlineRepository;

public class AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public void createAirline(Airline airline){
        airlineRepository.save(airline);
    }

    public void updateAirline(Airline airline){
        airlineRepository.update(airline);
    }

    public Optional<Airline> getAirlineById(int id_aerolinea){
        return airlineRepository.findById(id_aerolinea);
    }
    
    public void deleteAirline(int id_aerolinea){
        airlineRepository.delete(id_aerolinea);
    }

    public List<Airline> getAllAirlines(){
        return airlineRepository.findAll();
    }
}
