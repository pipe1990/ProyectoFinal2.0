package com.example.ProyectoFinal.jpa.repositories;

import com.example.ProyectoFinal.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepositoryImpl implements VetRepository {
    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Save a Vet
     *
     * @param vet: Vet
     * @return Optional of Vet
     */
    @Override
    public String save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return "The vet was successfully created";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "the vet could not be created";
    }

    /**
     * Find by username a Vet
     *
     * @param username: String
     * @return Optional of Vet
     */
    @Override
    public Optional<Vet> findByUserName(String username) {
        Vet vet = entityManager.find(Vet.class, username);
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findById(Integer vetId) {
        Vet vet = entityManager.find(Vet.class, vetId);
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    /**
     * Find all the Vets
     *
     * @return List of all Vets
     */
    @Override
    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet").getResultList();
    }

    /**
     * Delete by username a Vet
     *
     * @param username: String
     */
    @Override
    public String deleteByUserName(String username) {
        Vet vet = entityManager.find(Vet.class, username);
        if (vet != null) {
            try {

                entityManager.getTransaction().begin();

                vet.getVisits().forEach(visit -> {
                    entityManager.remove(visit);
                });

                entityManager.remove(vet);
                entityManager.getTransaction().commit();
                return "the vet was successfully removed";

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "the vet could not be eliminated";
    }



    @Override
    public String editVet(String username, String password, String email, String role, Integer vetId, String name, String address, String neighborhood) {
        Vet vet = entityManager.find(Vet.class, username);
        if (vet != null) {
            try {
                entityManager.getTransaction().begin();
                vet.setPassword(password);
                vet.setEmail(email);
                vet.setRole(role);
                vet.setName(name);
                vet.setAddress(address);
                vet.setNeighborhood(neighborhood);
                entityManager.getTransaction().commit();
                return "the vet was modified correctly";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "the vet could not be modified";
    }

}
