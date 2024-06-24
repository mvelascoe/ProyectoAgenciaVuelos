package com.proyectojava.tripulationroles.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.tripulationroles.domain.models.Tripulationroles;
import com.proyectojava.tripulationroles.infrastructure.TripulationrolesRepository;

public class TripulationrolesService {
    private final TripulationrolesRepository tripulationrolesRepository;

    public TripulationrolesService(TripulationrolesRepository tripulationrolesMySQLRepository) {
        this.tripulationrolesRepository = tripulationrolesMySQLRepository;
    }

    public void createTripulationroles(Tripulationroles tripulationroles){
        tripulationrolesRepository.save(tripulationroles);
    }

    public void updateTripulationroles(Tripulationroles tripulationroles){
        tripulationrolesRepository.update(tripulationroles);
    }

    public Optional<Tripulationroles> findTripulationrolesById(int id_rol){
        return tripulationrolesRepository.findById(id_rol);
    }

    public void deleteTripulationroles(int id_rol){
        tripulationrolesRepository.delete(id_rol);
    }

    public List<Tripulationroles> getAllTripulationroles(){
        return tripulationrolesRepository.findAll();
    }
}
