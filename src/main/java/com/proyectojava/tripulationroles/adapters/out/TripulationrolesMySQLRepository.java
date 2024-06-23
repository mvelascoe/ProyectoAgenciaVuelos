package com.proyectojava.tripulationroles.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.tripulationroles.domain.models.Tripulationroles;
import com.proyectojava.tripulationroles.infrastructure.TripulationrolesRepository;

public class TripulationrolesMySQLRepository implements TripulationrolesRepository{

    @Override
    public void save(Tripulationroles tripulationroles) {

    }

    @Override
    public void update(Tripulationroles tripulationroles) {

    }

    @Override
    public Optional<Tripulationroles> findById(int id_rol) {
        return null;
  
    }

    @Override
    public void delete(int id_rol) {

    }

    @Override
    public List<Tripulationroles> findAll() {

        return null;

    }

}
