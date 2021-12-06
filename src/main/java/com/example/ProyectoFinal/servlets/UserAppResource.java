package com.example.ProyectoFinal.servlets;

import com.example.ProyectoFinal.jpa.entities.UserApp;
import com.example.ProyectoFinal.jpa.repositories.UserAppRepository;
import com.example.ProyectoFinal.jpa.repositories.UserAppRepositoryImpl;
import com.example.ProyectoFinal.servlets.filtrar.Logged;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/user/")
public class UserAppResource {
    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {
        if (!"official".equals(role) && !"vet".equals(role) && !"owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity(role)
                .build();
    }
    @GET
    @Path("/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUser(@PathParam("username")String username) {

       UserAppRepository userAppRepository;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LazarusAES-256");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        Optional<UserApp> user = userAppRepository.findByUsername(username);

        if (user.isPresent()) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Usuario Creado")
                    .build();
        }


        return Response.ok()
                .entity("Usuario no creado")
                .build();
    }
}
