package com.proyectojava.rols.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.rols.domain.models.Rols;

public interface RolsRepository {
    void save(Rols rols);
    void update(Rols rols);
    Optional<Rols> findById(int id_rol);
    void delete(int id_rol);
    List<Rols> findAll();
}
