package com.progamacion.distribuida.books.rest;

import com.progamacion.distribuida.books.db.Book;
import com.progamacion.distribuida.books.repo.BookRespository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRest {
    final BookRespository bookRespository;

    @Inject
    public BookRest(BookRespository bookRespository){
        this.bookRespository = bookRespository;
    }

    @GET
    public List<Book> findAll(){
        System.out.println("Aqui");
        return  bookRespository.listAll();
    }

    @GET
    @Path("/{isbn}")
    public Response getById(@PathParam("isbn") String isbn){
        return bookRespository.findByIdOptional(isbn)
                .map(author -> Response.ok(author).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

}
