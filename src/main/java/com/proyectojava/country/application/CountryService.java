package com.proyectojava.country.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.country.domain.models.Country;
import com.proyectojava.country.infrastructure.CountryRepository;

public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void createCountry(Country country){
        countryRepository.save(country);
    }

    public void updateCountry(Country country){
        countryRepository.update(country);
    }

    public Optional<Country> findCityById(String id_pais){
        return countryRepository.findById(id_pais);
    }

    public void deleteCity(String id_pais){
        countryRepository.delete(id_pais);
    }

    public List<Country> findAllCountrys(){
        return countryRepository.findAll();
    }
}
