package com.proyectojava.airport.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.airport.infrastructure.AirportRepository;
import com.proyectojava.cities.domain.models.Cities;
import com.proyectojava.cities.infrastructure.CitiesRepository;

public class AirportService {
    private final AirportRepository airportRepository;
    private final CitiesRepository citiesRepository;

    public AirportService(AirportRepository airportRepository,CitiesRepository citiesRepository) {
        this.airportRepository = airportRepository;
        this.citiesRepository = citiesRepository;
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

    //METODOS PARA TRAER LAS CIUDADES

    public List<Cities> allCities(){
        return citiesRepository.findAll();
    }

    public Optional<Cities> citiesByID(String id_ciudad){
        return citiesRepository.findById(id_ciudad);
    }

    public void updateCity(Cities cities){
        citiesRepository.update(cities);
    }
}   

