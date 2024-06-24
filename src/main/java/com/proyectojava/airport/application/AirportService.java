package com.proyectojava.airport.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.airport.infrastructure.AirportRepository;

public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void createAirport(Airport airport){
        airportRepository.save(airport);
    }

    public void updateAirport(Airport airport){
        airportRepository.update(airport);
    }

    public Optional<Airport> findAirportById(String id_aeropuerto){
        return airportRepository.findById(id_aeropuerto);
    }

    public void deleteAirport(String id_aeropuerto){
        airportRepository.delete(id_aeropuerto);
    }

    public List<Airport> findAllAirports(){
        return airportRepository.findAll();
    }
}
