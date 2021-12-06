package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Case;

import java.util.List;
import java.util.Optional;

public interface CaseRepository {
    String save(Case aCase);

    Optional<Case> findById(Integer id);

    List<Case> findAll();

    String deleteById(Integer id);

    String editCase(Integer id, String created_at, String type, String description);
}
