package com.progamacion.distribuida.books.services.interfaces;

import com.progamacion.distribuida.books.dtos.BookDto;

import java.util.List;

public interface BookService {

     List<BookDto> findAll();

     BookDto findByIsbn(String isbn);
}
