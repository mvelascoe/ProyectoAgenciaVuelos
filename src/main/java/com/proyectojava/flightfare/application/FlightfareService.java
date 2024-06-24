package com.proyectojava.flightfare.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.flightfare.domain.models.Flightfare;
import com.proyectojava.flightfare.infrastructure.FlightfareRepository;

public class FlightfareService {
    private final FlightfareRepository flightfareRepository;

    public FlightfareService(FlightfareRepository flightfareRepository) {
        this.flightfareRepository = flightfareRepository;
    }

    public void createFlightFare(Flightfare flightfare){
        flightfareRepository.save(flightfare);
    }

    public void updateFligtFare(Flightfare flightfare){
        flightfareRepository.update(flightfare);
    }

    public Optional<Flightfare> findFligthFareById(int id_tarifa){
        return flightfareRepository.findById(id_tarifa);
    }

    public void deleteFlightFare(int id_tarifa){
        flightfareRepository.delete(id_tarifa);
    }

    public List<Flightfare> findAllFlightfares(){
        return flightfareRepository.findAll();
    }
}
