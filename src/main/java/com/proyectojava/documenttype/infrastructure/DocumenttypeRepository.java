package com.proyectojava.documenttype.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.documenttype.domain.models.Documenttype;

public interface DocumenttypeRepository {
    public void save(Documenttype documenttype);
    public void update(Documenttype documenttype);
    public Optional<Documenttype> findById(int id_documento);
    public void delete(int id_documento);
    public List<Documenttype> findAll();
}
