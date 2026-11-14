package com.progamacion.distribuida.books.repo;

import com.progamacion.distribuida.books.db.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class BookRespository implements PanacheRepositoryBase<Book, String> {

}
