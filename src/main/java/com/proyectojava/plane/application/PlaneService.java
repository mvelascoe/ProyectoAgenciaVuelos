package com.proyectojava.plane.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.models.domain.models.Model;
import com.proyectojava.models.infrastructure.ModelRepository;
import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.plane.infrastructure.PlaneRepository;
import com.proyectojava.statusA.domain.models.Status;
import com.proyectojava.statusA.infrastructure.StatusRepository;

public class PlaneService {
    private final PlaneRepository planeRepository;
    private final StatusRepository statusRepository;
    private final ModelRepository modelRepository;

    public PlaneService(PlaneRepository planeRepository, StatusRepository statusRepository,
            ModelRepository modelRepository) {
        this.planeRepository = planeRepository;
        this.modelRepository = modelRepository;
        this.statusRepository = statusRepository;
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

    // Metodos para traer de Status

    public void updateStatus(Status status) {
        statusRepository.update(status);
    }

    public Optional<Status> getStatusById(int id_estado) {
        return statusRepository.findById(id_estado);
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    //Metodos de model

    
    public void updateModel(Model model) {
        modelRepository.update(model);
    }

    public Optional<Model> getModelById(int id_modelo) {
        return modelRepository.findById(id_modelo);
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }
}
