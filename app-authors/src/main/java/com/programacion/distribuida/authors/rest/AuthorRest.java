    package com.programacion.distribuida.authors.rest;

    import com.programacion.distribuida.authors.db.Author;
    import com.programacion.distribuida.authors.repo.AuthorRespository;
    import jakarta.inject.Inject;
    import jakarta.ws.rs.*;
    import jakarta.ws.rs.core.MediaType;
    import jakarta.ws.rs.core.Response;

    import java.util.List;

    @Path("/authors")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class AuthorRest {

        final AuthorRespository authorRespository;

        @Inject
        public AuthorRest(AuthorRespository authorRespository){
            this.authorRespository = authorRespository;
        }

        @GET
        public List<Author> getAll(){
            return authorRespository.listAll();
        }

        @GET
        @Path("/{id}")
        public Response getById(@PathParam("id") Integer id){
            return authorRespository.findByIdOptional(id)
                    .map(author -> Response.ok(author).build())
                    .orElse(Response.status(Response.Status.NOT_FOUND).build());
        }

        @GET
        @Path("/find/{isbn}")
        public List<Author> findByBook(@PathParam("isbn") String isbn){
            return authorRespository.findByBook(isbn);
        }
    }
