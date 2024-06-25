package com.proyectojava.cities.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.cities.domain.models.Cities;
import com.proyectojava.cities.infrastructure.CitiesRepository;

public class CitiesService {
    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public void createCity(Cities cities){
        citiesRepository.save(cities);
    }

    public void updateCity(Cities cities){
        citiesRepository.update(cities);
    }

    public Optional<Cities> getCityById(String id_ciudad){
        return citiesRepository.findById(id_ciudad);
    }

    public void deleteCity(String id_ciudad){
        citiesRepository.delete(id_ciudad);
    }

    public List<Cities>getAllCities(){
        return citiesRepository.findAll();
    }
}
