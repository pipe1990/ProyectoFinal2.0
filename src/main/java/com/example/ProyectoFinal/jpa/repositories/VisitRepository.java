package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    String save(Visit visit);


    List<Visit> findAll();


}
