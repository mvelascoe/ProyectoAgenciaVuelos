package com.proyectojava.plane.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.plane.infrastructure.PlaneRepository;

public class PlaneService {
private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public void createPlane(Plane plane) {
        planeRepository.save(plane);
    }

    public void updatePlane(Plane plane) {
        planeRepository.update(plane);
    }

    public Optional<Plane> getPlaneById(int id_avion) {
        return planeRepository.findById(id_avion);
    }

    public void deletePlane(int id_avion) {
        planeRepository.delete(id_avion);
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }
}
