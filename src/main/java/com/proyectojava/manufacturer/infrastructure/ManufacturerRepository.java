package com.proyectojava.manufacturer.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.manufacturer.domain.models.Manufacturer;

public interface ManufacturerRepository {
    void save(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    Optional<Manufacturer>findById(int id_manufactura);
    void delete(int id_manufactura);
    List<Manufacturer>findAll();
}
