package com.proyectojava.plane.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.plane.infrastructure.PlaneRepository;

public class PlaneMySQLRepository implements PlaneRepository{

    @Override
    public void save(Plane plane) {

    }

    @Override
    public void update(Plane plane) {

    }

    @Override
    public Optional<Plane> findById(int id_avion) {
        return null;

    }

    @Override
    public void delete(int id_avion) {

    }

    @Override
    public List<Plane> findAll() {
        return null;

    }

}
