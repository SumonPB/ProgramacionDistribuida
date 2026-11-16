package com.progamacion.distribuida.books.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Integer id;
    private Integer version;
    private String name;
}
