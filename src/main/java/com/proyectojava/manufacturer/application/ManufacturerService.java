package com.proyectojava.manufacturer.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.manufacturer.domain.models.Manufacturer;
import com.proyectojava.manufacturer.infrastructure.ManufacturerRepository;

public class ManufacturerService {
 private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void createManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.update(manufacturer);
    }

    public Optional<Manufacturer> getManufacturerById(int id_manufactura) {
        return manufacturerRepository.findById(id_manufactura);
    }

    public void deleteManufacturer(int id_manufactura) {
        manufacturerRepository.delete(id_manufactura);
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }
}
