package com.proyectojava.revisions.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.plane.infrastructure.PlaneRepository;
import com.proyectojava.revisions.domain.models.Revisions;
import com.proyectojava.revisions.infrastructure.RevisionsRepository;

public class RevisionsService {
    private final RevisionsRepository revisionsRepository;
    private final PlaneRepository planeRepository;


    public RevisionsService(RevisionsRepository revisionsRepository, PlaneRepository planeRepository) {
        this.revisionsRepository = revisionsRepository;
        this.planeRepository = planeRepository;
    }

    public void createRevision(Revisions revisions) {
        revisionsRepository.save(revisions);
    }

    public void updateRevision(Revisions revisions) {
        revisionsRepository.update(revisions);
    }

    public Optional<Revisions> getRevisionById(int id_revision) {
        return revisionsRepository.findById(id_revision);
    }

    public void deleteRevision(int id_revision) {
        revisionsRepository.delete(id_revision);
    }

    public List<Revisions> getAllRevisions() {
        return revisionsRepository.findAll();
    }

    //METODOS DE PLANE
    public Optional<Plane> findPlane(int id_avion){
        return planeRepository.findById(id_avion);
    }

    public List<Plane> allPlane(){
        return planeRepository.findAll();
    }
}
