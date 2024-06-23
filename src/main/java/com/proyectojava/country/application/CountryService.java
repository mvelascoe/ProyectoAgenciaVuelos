package com.proyectojava.country.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.country.adapters.out.CountryMySQLRepository;
import com.proyectojava.country.domain.models.Country;

public class CountryService {
    private final CountryMySQLRepository countryMySQLRepository;

    public CountryService(CountryMySQLRepository countryMySQLRepository) {
        this.countryMySQLRepository = countryMySQLRepository;
    }

    public void createCountry(Country country){
        countryMySQLRepository.save(country);
    }

    public void updateCountry(Country country){
        countryMySQLRepository.update(country);
    }

    public Optional<Country> findCityById(String id_pais){
        return countryMySQLRepository.findById(id_pais);
    }

    public void deleteCity(String id_pais){
        countryMySQLRepository.delete(id_pais);
    }

    public List<Country> findAllCountrys(){
        return countryMySQLRepository.findAll();
    }
}
