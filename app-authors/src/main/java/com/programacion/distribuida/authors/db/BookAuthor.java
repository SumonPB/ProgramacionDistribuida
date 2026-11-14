package com.programacion.distribuida.authors.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "book_author")
@ToString
public class BookAuthor {
    @EmbeddedId
    private BookAuthorID id;

    @ManyToOne
    @JoinColumn(name ="authors_id",insertable = false,updatable = false)
    @ToString.Exclude
    private Author author;



}
