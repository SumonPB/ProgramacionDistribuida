package com.progamacion.distribuida.books.dtos;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.progamacion.distribuida.books.db.Book}
 */
@Setter
@Getter
@ToString
@Builder
public class BookDto {
    private String isbn;
    private String title;
    private BigDecimal price;
    private Integer inventorySold;
    private Integer inventorySupplier;
    private List<AuthorDto> authors;
}