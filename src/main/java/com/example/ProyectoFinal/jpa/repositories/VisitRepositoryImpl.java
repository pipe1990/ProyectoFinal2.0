package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository {

  private EntityManager entityManager;

  public VisitRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public String save(Visit visit) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(visit);
      entityManager.getTransaction().commit();
      return "has been successfully registered";
    } catch (Exception e) {
      return "An error occurred while registering the visit!";
    }
  }

  @Override
  public List<Visit> findAll() {
    return entityManager.createQuery("from Visit ").getResultList();
  }


}
