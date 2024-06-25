package com.proyectojava.rols.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.rols.domain.models.Rols;
import com.proyectojava.rols.infrastructure.RolsRepository;

public class RolsService {
    private final RolsRepository rolsRepository;

    public RolsService(RolsRepository rolsRepository) {
        this.rolsRepository = rolsRepository;
    }

    public void createRol(Rols rols){
        rolsRepository.save(rols);
    }

    public void updateRol(Rols rols){
        rolsRepository.update(rols);
    }

    public Optional<Rols> findRolById(int id_rol){
        return rolsRepository.findById(id_rol);
    }

    public void deleteRol(int id_rol){
        rolsRepository.delete(id_rol);
    }

    public List<Rols> findAllRols(){
        return rolsRepository.findAll();
    }
}
