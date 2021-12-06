package com.example.ProyectoFinal.jpa.repositories;
import com.example.ProyectoFinal.jpa.entities.Pet;
import com.example.ProyectoFinal.servlets.pojos.PetPOJO;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    String save(Pet pet);

    Optional<Pet> findById(Integer id);

    List findAll(Integer petId);

    List<Pet> findAll();
    List<Pet> findbyOwner(String username);
    String editPet(PetPOJO petPOJO);
    void deleteById(Integer id);

}
