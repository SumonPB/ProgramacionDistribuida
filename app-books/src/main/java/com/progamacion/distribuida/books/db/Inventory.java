package com.progamacion.distribuida.books.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "inventory")
@ToString
public class Inventory{
    @Id
    @OneToOne
    @JoinColumn(name = "book_isbn")
    @ToString.Exclude
    private Book book;

    private Integer sold;

    private  Integer supplier;


}
