

package com.example.ProyectoFinal.servlets;

import com.example.ProyectoFinal.servlets.filtrar.Logged;
import com.example.ProyectoFinal.servlets.pojos.OwnerPOJO;
import com.example.ProyectoFinal.services.OwnerService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/owners/{username}")
public class OwnerResource {
    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello " + role + " !!")
                .build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String username, OwnerPOJO ownerPOJO) {
        ownerPOJO.setUsername(username);
        String reply = new OwnerService().createOwner(ownerPOJO);

        return Response.
                status(Response.Status.CREATED)
                .entity(reply)
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modifyOwner(OwnerPOJO ownerPojo) {
        String reply = new OwnerService().editOwner(ownerPojo);
        return Response.status(Response.Status.OK).entity(reply).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOwner(@PathParam("username") String username) {
        String reply = new OwnerService().deleteOwner(username);
        return Response.status(Response.Status.OK).entity(reply).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalOwners() {
        List<OwnerPOJO> ownerPOJO = new OwnerService().listOwners();
        return Response.ok().entity(ownerPOJO).build();
    }

}
