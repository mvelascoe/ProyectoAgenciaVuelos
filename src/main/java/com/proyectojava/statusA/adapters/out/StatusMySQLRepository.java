package com.proyectojava.statusA.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.statusA.domain.models.Status;
import com.proyectojava.statusA.infrastructure.StatusRepository;

public class StatusMySQLRepository implements StatusRepository {

    @Override
    public void save(Status status) {

    }

    @Override
    public void update(Status status) {

    }

    @Override
    public Optional<Status> findById(int id_estado) {
        return null;

    }

    @Override
    public void delete(int id_estado) {

    }

    @Override
    public List<Status> findAll() {
        return null;

    }

}
