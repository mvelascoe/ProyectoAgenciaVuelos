package com.proyectojava.documenttype.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.documenttype.adapters.out.DocumenttypeMySQLRepository;
import com.proyectojava.documenttype.domain.models.Documenttype;

public class DocumenttypeService {
    private final DocumenttypeMySQLRepository documenttypeMySQLRepository;

    public DocumenttypeService(DocumenttypeMySQLRepository documenttypeMySQLRepository) {
        this.documenttypeMySQLRepository = documenttypeMySQLRepository;
    }

    public void createDocument(Documenttype documenttype){
        documenttypeMySQLRepository.save(documenttype);
    }

    public void updateDocument(Documenttype documenttype){
        documenttypeMySQLRepository.update(documenttype);
    }

    public Optional<Documenttype> findDocumentById(int id_documento){
        return documenttypeMySQLRepository.findById(id_documento);
    }

    public void deleteDocument(int id_documento){
        documenttypeMySQLRepository.delete(id_documento);
    }

    public List<Documenttype> findAllDocument(int id_documento){
        return documenttypeMySQLRepository.findAll();
    }
}

