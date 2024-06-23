package com.proyectojava.cities.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.cities.domain.models.Cities;

public interface CitiesRepository {
    void save(Cities cities);
    void update(Cities cities);
    Optional<Cities> findById(String id_ciudad);
    void delete (String id_ciudad);
    List<Cities>findAll();
}
