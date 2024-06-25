package com.proyectojava.documenttype.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.documenttype.domain.models.Documenttype;
import com.proyectojava.documenttype.infrastructure.DocumenttypeRepository;

public class DocumenttypeService {
    private final DocumenttypeRepository documenttypeRepository;

    public DocumenttypeService(DocumenttypeRepository documenttypeRepository) {
        this.documenttypeRepository = documenttypeRepository;
    }

    public void createDocument(Documenttype documenttype){
        documenttypeRepository.save(documenttype);
    }

    public void updateDocument(Documenttype documenttype){
        documenttypeRepository.update(documenttype);
    }

    public Optional<Documenttype> findDocumentById(int id_documento){
        return documenttypeRepository.findById(id_documento);
    }

    public void deleteDocument(int id_documento){
        documenttypeRepository.delete(id_documento);
    }

    public List<Documenttype> findAllDocument(){
        return documenttypeRepository.findAll();
    }
}

