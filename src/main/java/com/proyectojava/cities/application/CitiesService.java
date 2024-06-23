package com.proyectojava.cities.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.cities.adapters.out.CitiesMySQLRepository;
import com.proyectojava.cities.domain.models.Cities;

public class CitiesService {
    private final CitiesMySQLRepository citiesMySQLRepository;

    public CitiesService(CitiesMySQLRepository citiesMySQLRepository) {
        this.citiesMySQLRepository = citiesMySQLRepository;
    }

    public void createCity(Cities cities){
        citiesMySQLRepository.save(cities);
    }

    public void updateCity(Cities cities){
        citiesMySQLRepository.update(cities);
    }

    public Optional<Cities> findCityById(String id_ciudad){
        return citiesMySQLRepository.findById(id_ciudad);
    }

    public void deleteCity(String id_ciudad){
        citiesMySQLRepository.delete(id_ciudad);
    }

    public List<Cities>findAllCities(){
        return citiesMySQLRepository.findAll();
    }
}
