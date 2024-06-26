package com.proyectojava.cities.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.cities.domain.models.Cities;
import com.proyectojava.cities.infrastructure.CitiesRepository;
import com.proyectojava.country.infrastructure.CountryRepository;
import com.proyectojava.country.domain.models.Country;


public class CitiesService {
    private final CitiesRepository citiesRepository;
    private final CountryRepository countryRepository; // Constante para Pais

    public CitiesService(CitiesRepository citiesRepository, CountryRepository countryRepository) { //inyecto CountryRepository
        this.citiesRepository = citiesRepository;
        this.countryRepository = countryRepository ;
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

    //Metodos para traer los paises

    public List<Country> findAllCountrys(){
        return countryRepository.findAll();
    }

    public Optional<Country> findCountryById(String id_pais){
        return countryRepository.findById(id_pais);
    }

    public void updateCountry(Country country){
        countryRepository.update(country);
    }

}
