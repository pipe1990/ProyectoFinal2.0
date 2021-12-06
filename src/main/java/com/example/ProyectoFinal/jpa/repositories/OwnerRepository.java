package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    String save(Owner owner);

    Optional<Owner> findByUsername(String Username);

    List<Owner> findAll();

    String deleteByUsername(String username);

    String editOwner (String username, String password, String email, Integer personId, String name, String adress,String neighborhood);
}
