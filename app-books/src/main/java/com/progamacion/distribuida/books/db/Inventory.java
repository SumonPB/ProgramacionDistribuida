package com.progamacion.distribuida.books.db;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "inventory")
@ToString
public class Inventory implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "book_isbn")
    @ToString.Exclude
    @JsonbTransient
    private Book book;

    private Integer sold;

    @Column(name = "supplied")
    private Integer supplied;
}