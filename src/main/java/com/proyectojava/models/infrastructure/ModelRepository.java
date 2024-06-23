package com.proyectojava.models.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.models.domain.models.Model;

public interface ModelRepository {
    void save(Model model);
    void update (Model model);
    Optional<Model>findById(int id_modelo);
    void delete(int id_modelo);
    List<Model>findAll();
}
