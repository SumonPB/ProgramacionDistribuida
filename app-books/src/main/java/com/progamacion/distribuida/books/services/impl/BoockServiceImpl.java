package com.progamacion.distribuida.books.services.impl;

import com.progamacion.distribuida.books.db.Book;
import com.progamacion.distribuida.books.dtos.BookDto;
import com.progamacion.distribuida.books.repo.BookRespository;
import com.progamacion.distribuida.books.services.interfaces.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class BoockServiceImpl implements BookService {
    final BookRespository bookRespository;

    @Inject
    public BoockServiceImpl(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
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
        return bookRespository.streamAll().map(this::toDTo).toList();
    }

    public BookDto findByOptional(String isbn) {
        return bookRespository.findByIdOptional(isbn).map(this::toDTo).orElse(null);
    }

}
