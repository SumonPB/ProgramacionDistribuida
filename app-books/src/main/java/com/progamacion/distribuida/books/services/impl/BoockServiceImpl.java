package com.progamacion.distribuida.books.services.impl;

import com.progamacion.distribuida.books.clients.AuthorRestClient;
import com.progamacion.distribuida.books.db.Book;
import com.progamacion.distribuida.books.dtos.AuthorDto;
import com.progamacion.distribuida.books.dtos.BookDto;
import com.progamacion.distribuida.books.repo.BookRespository;
import com.progamacion.distribuida.books.services.interfaces.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@Transactional
public class BoockServiceImpl implements BookService {
    final BookRespository bookRespository;
    final AuthorRestClient authorRestClient;

    @Inject
    public BoockServiceImpl(BookRespository bookRespository, @RestClient AuthorRestClient authorRestClient) {
        this.bookRespository = bookRespository;
        this.authorRestClient = authorRestClient;
    }

    private BookDto toDTo(Book book){
        return BookDto.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .price(book.getPrice())
                .inventorySold(book.getInventory()!=null ? book.getInventory().getSold() : null)
                .inventorySupplier(book.getInventory()!=null ? book.getInventory().getSupplier() : null)
                .build();
    }

    public List<BookDto> findAll() {

        return bookRespository.streamAll()
                .map(this::toDTo)
                .peek(it->{
                    var authors = authorRestClient.findByBook(it.getIsbn());
                    it.setAuthors(authors);
                })
                .toList();
    }

    public BookDto findByOptional(String isbn) {
        List<AuthorDto> authors = authorRestClient.findByBook(isbn);
        return bookRespository.findByIdOptional(isbn)
                .map(this::toDTo)
                .map(it->{
                    it.setAuthors(authors);
                    return it;
                }).orElse(null);

    }

}
