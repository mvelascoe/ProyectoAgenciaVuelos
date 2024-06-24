package com.proyectojava.models.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.models.domain.models.Model;
import com.proyectojava.models.infrastructure.ModelRepository;

public class ModelService {
 private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
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
}
