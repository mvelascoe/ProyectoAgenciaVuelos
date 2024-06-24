package com.proyectojava.revisions.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.revisions.domain.models.Revisions;
import com.proyectojava.revisions.infrastructure.RevisionsRepository;

public class RevisionsService {
    private final RevisionsRepository revisionsRepository;

    public RevisionsService(RevisionsRepository revisionsRepository) {
        this.revisionsRepository = revisionsRepository;
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
}
