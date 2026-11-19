package com.progamacion.distribuida.books.clients;

import com.progamacion.distribuida.books.dtos.AuthorDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@RegisterRestClient(baseUri = "http://localhost:8070")
@RegisterRestClient(configKey = "AuthorsRestClient")
public interface AuthorRestClient {

/*    @GET
     List<AuthorDto> getAll();

    @GET
    @Path("/{id}")
     Response getById(@PathParam("id") Integer id);*/

    @GET
    @Path("/find/{isbn}")
     List<AuthorDto> findByBook(@PathParam("isbn") String isbn);



}
