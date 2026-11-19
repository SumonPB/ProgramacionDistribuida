package com.progamacion.distribuida.books.rest;

import com.progamacion.distribuida.books.db.Book;
import com.progamacion.distribuida.books.dtos.BookDto;
import com.progamacion.distribuida.books.repo.BookRespository;
import com.progamacion.distribuida.books.services.impl.BoockServiceImpl;
import com.progamacion.distribuida.books.services.interfaces.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRest {
    final BookService bookRespository;


    @Inject
    public BookRest(BoockServiceImpl bookRespository){
        this.bookRespository = bookRespository;
    }

    @GET
    public List<BookDto> findAll(){
        return  bookRespository.findAll();
    }
//
//    @GET
//    @Path("/{isbn}")
//    public Response getById(@PathParam("isbn") String isbn){
//        return bookRespository.findByOptional(isbn);
//    }

}
