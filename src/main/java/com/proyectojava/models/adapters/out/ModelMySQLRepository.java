package com.proyectojava.models.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.models.domain.models.Model;
import com.proyectojava.models.infrastructure.ModelRepository;

public class ModelMySQLRepository implements ModelRepository {

    @Override
    public void save(Model model) {

    }

    @Override
    public void update(Model model) {

    }

    @Override
    public Optional<Model> findById(int id_modelo) {
        return null;

    }

    @Override
    public void delete(int id_modelo) {

    }

    @Override
    public List<Model> findAll() {
        return null;

    }

}
