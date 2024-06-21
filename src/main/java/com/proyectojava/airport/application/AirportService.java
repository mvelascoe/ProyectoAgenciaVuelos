package com.proyectojava.airport.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.adapters.out.AirportMySQLRepository;
import com.proyectojava.airport.domain.models.Airport;

public class AirportService {
    private final AirportMySQLRepository airportMySQLRepository;

    public AirportService(AirportMySQLRepository airportMySQLRepository) {
        this.airportMySQLRepository = airportMySQLRepository;
    }

    public void createAirport(Airport airport){
        airportMySQLRepository.save(airport);
    }

    public void updateAirport(Airport airport){
        airportMySQLRepository.update(airport);
    }

    public Optional<Airport> findAirportById(String id_aeropuerto){
        return airportMySQLRepository.findById(id_aeropuerto);
    }

    public void deleteAirport(String id_aeropuerto){
        airportMySQLRepository.delete(id_aeropuerto);
    }

    public List<Airport> findAllAirports(){
        return airportMySQLRepository.findAll();
    }
}
