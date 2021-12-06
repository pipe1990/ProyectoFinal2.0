package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.UserApp;

import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByUsername(String username);

    Optional<UserApp> save(UserApp user);

}
