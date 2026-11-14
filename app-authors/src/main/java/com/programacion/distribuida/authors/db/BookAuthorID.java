package com.programacion.distribuida.authors.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class BookAuthorID {
    @Column(name = "books_isbn")
    private String bookIsbn;

    @Column(name = "authors_id")
    private Integer authorId;
}
