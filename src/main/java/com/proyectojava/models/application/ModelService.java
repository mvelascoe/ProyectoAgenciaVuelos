package com.proyectojava.models.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.manufacturer.domain.models.Manufacturer;
import com.proyectojava.manufacturer.infrastructure.ManufacturerRepository;
import com.proyectojava.models.domain.models.Model;
import com.proyectojava.models.infrastructure.ModelRepository;

public class ModelService {
 private final ModelRepository modelRepository;
 private final ManufacturerRepository manufacturerRepository;

    public ModelService(ModelRepository modelRepository, ManufacturerRepository manufacturerRepository) {
    this.modelRepository = modelRepository;
    this.manufacturerRepository = manufacturerRepository;
}

    public void createModel(Model model) {
        modelRepository.save(model);
    }

    public void updateModel(Model model) {
        modelRepository.update(model);
    }

    public Optional<Model> getModelById(int id_modelo) {
        return modelRepository.findById(id_modelo);
    }

    public void deleteModel(int id_modelo) {
        modelRepository.delete(id_modelo);
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    // METODOS PARA TRAER EL MANUFACTURER

    public List<Manufacturer>allManufacturer(){
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer>findManufacurer(int id_manufactura){
        return manufacturerRepository.findById(id_manufactura);
    }

    public void updateManufacturer(Manufacturer manufacturer){
        manufacturerRepository.update(manufacturer);
    }
}
