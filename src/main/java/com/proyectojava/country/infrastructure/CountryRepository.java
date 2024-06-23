package com.proyectojava.country.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.country.domain.models.Country;

public interface CountryRepository {
    void save(Country country);
    void update(Country country);
    Optional<Country>findById(String id_pais);
    void delete (String id_pais);
    List<Country>findAll();
}
