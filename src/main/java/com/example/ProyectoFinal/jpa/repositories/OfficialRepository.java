package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    String save(Official oficial);

    List<Official> listAll();

    List<Official> getByUsername(String username);

}
