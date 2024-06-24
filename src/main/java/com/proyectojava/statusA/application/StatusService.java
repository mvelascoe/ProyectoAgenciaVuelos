package com.proyectojava.statusA.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.statusA.domain.models.Status;
import com.proyectojava.statusA.infrastructure.StatusRepository;

public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void createStatus(Status status) {
        statusRepository.save(status);
    }

    public void updateStatus(Status status) {
        statusRepository.update(status);
    }

    public Optional<Status> getStatusById(int id_estado) {
        return statusRepository.findById(id_estado);
    }

    public void deleteStatus(int id_estado) {
        statusRepository.delete(id_estado);
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

}
