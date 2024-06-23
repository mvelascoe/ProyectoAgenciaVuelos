package com.proyectojava.statusA.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.statusA.domain.models.Status;

public interface StatusRepository {
    void save (Status status);
    void update (Status status);
    Optional<Status> findById(int id_estado);
    void delete(int id_estado);
    List<Status> findAll();
}
