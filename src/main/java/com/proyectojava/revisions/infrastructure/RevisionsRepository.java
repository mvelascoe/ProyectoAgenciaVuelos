package com.proyectojava.revisions.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.revisions.domain.models.Revisions;

public interface RevisionsRepository {
    void save (Revisions revisions);
    void update (Revisions revisions);
    Optional<Revisions>findById(int id_revision);
    void delete(int id_revision);
    List<Revisions>findAll();
    
}
