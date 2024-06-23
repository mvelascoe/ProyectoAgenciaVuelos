package com.proyectojava.revisions.adapters.out;

import java.util.List;
import java.util.Optional;

import com.proyectojava.revisions.domain.models.Revisions;
import com.proyectojava.revisions.infrastructure.RevisionsRepository;

public class RevisionsMySQLRepository implements RevisionsRepository{

    @Override
    public void save(Revisions revisions) {

    }

    @Override
    public void update(Revisions revisions) {

    }

    @Override
    public Optional<Revisions> findById(int id_revision) {
        return null;

    }

    @Override
    public void delete(int id_revision) {

    }

    @Override
    public List<Revisions> findAll() {
        return null;

    }

}
