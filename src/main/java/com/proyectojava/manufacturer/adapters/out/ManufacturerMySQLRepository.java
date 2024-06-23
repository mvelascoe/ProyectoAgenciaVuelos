package com.proyectojava.manufacturer.adapters.out;
import java.util.List;
import java.util.Optional;

import com.proyectojava.manufacturer.domain.models.Manufacturer;
import com.proyectojava.manufacturer.infrastructure.ManufacturerRepository;

public class ManufacturerMySQLRepository implements ManufacturerRepository{

    @Override
    public void save(Manufacturer manufacturer) {

    }

    @Override
    public void update(Manufacturer manufacturer) {

    }

    @Override
    public Optional<Manufacturer> findById(int id_manufactura) {
        return null;

    }

    @Override
    public void delete(int id_manufactura) {

    }

    @Override
    public List<Manufacturer> findAll() {
        return null;

    }

}
