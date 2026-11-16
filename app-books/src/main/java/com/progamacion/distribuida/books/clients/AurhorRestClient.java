package com.progamacion.distribuida.books.clients;

import com.progamacion.distribuida.books.dtos.AuthorDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AurhorRestClient {

/*    @GET
     List<AuthorDto> getAll();

    @GET
    @Path("/{id}")
     Response getById(@PathParam("id") Integer id);*/

    @GET
    @Path("/find/{isbn}")
     List<AuthorDto> findByBook(@PathParam("isbn") String isbn);

}
