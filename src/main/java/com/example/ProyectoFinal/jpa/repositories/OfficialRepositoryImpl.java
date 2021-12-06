package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.List;

public class OfficialRepositoryImpl implements OfficialRepository{
    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String save(Official oficial) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(oficial);
            entityManager.getTransaction().commit();
            return "The Official was successfully saved";
        }catch (Exception e) {
            System.out.println("The Official was successfully saved --> " + e);
            e.printStackTrace();
        }
        System.out.println("Unable to save the Official");
        return "Unable to save the Official";
    }

    @Override
    public List<Official> listAll() {
        return entityManager.createQuery("from Official").getResultList();
    }

    @Override
    public List<Official> getByUsername(String username) {
        return entityManager.createQuery("SELECT o FROM Official o WHERE o.username LIKE :userParam")
                .setParameter("userParam", username).getResultList();
    }
}
