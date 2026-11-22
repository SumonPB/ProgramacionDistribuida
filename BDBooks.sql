create table authors
(
    version integer not null,
    id      bigint  not null
        primary key,
    name    varchar(255)
);

alter table authors
    owner to postgres;

create table books
(
    price   numeric(8, 2) not null,
    version integer       not null,
    isbn    varchar(255)  not null
        primary key,
    title   varchar(255)
);

alter table books
    owner to postgres;

create table books_authors
(
    books_isbn varchar(255) not null
        constraint books_authors_books_isbn_fk
            references books
            on delete cascade,
    authors_id bigint       not null
        constraint books_authors_authors_id_fk
            references authors
            on delete cascade,
    constraint books_authors_pk
        primary key (books_isbn, authors_id)
);

alter table books_authors
    owner to postgres;

create table inventory
(
    sold      integer      not null,
    supplied  integer      not null,
    version   integer      not null,
    book_isbn varchar(255) not null
        primary key
        constraint inventory_books_isbn_fk
            references books
);

alter table inventory
    owner to postgres;

create table customers
(
    email   varchar(255) not null,
    name    varchar(255) not null,
    version integer      not null,
    id      bigint       not null
        primary key
);

alter table customers
    owner to postgres;

create table purchaseorders
(
    deliveredon timestamp not null,
    placedon    timestamp not null,
    status      integer   not null,
    total       integer   not null,
    id          bigint    not null
        constraint purchaseorders_pk
            primary key,
    customer_id bigint    not null
        constraint purchaseorders_customers_id_fk
            references customers
            on delete cascade
);

alter table purchaseorders
    owner to postgres;

create table lineitems
(
    quantity  integer      not null,
    book_isbn varchar(255) not null
        constraint lineitems_books_isbn_fk
            references books
            on delete cascade,
    idx       integer      not null,
    order_id  bigint       not null
        constraint lineitems_purchaseorders_id_fk
            references purchaseorders
            on delete cascade,
    constraint lineitems_pk
        primary key (idx, order_id)
);

alter table lineitems
    owner to postgres;

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE
VALUES (1, 2, 'Herbert Schildt');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE
VALUES (1, 3, 'Kathy Sierra');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE
VALUES (1, 4, 'Brian Goetz');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE
VALUES (1, 5, 'Robert C. Martin');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE
VALUES (3, 1, 'Joshua Bloch');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (40.00, 1, '978-0596009205', 'Head First Java');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (55.00, 1, '978-0321349606', 'Java Concurrency in Practice');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (50.00, 1, '978-0136083238', 'Clean Code: A Handbook of Agile Software Craftsmanship');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (45.00, 1, '978-0134686097', 'Effective Java');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (50.00, 1, '978-1260440232', 'Java: The Complete Reference');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (1, '978-0134686097');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (2, '978-1260440232');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (3, '978-0596009205');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (4, '978-0321349606');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (5, '978-0136083238');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (5, '978-0134686097');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (1, '978-1260440232');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (2, '978-0596009205');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (3, '978-0321349606');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (4, '978-0136083238');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (1, '978-0136083238');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE
VALUES (2, '978-0136083238');

INSERT INTO public.inventory (sold, supplied, version, book_isbn) OVERRIDING SYSTEM VALUE
VALUES (10, 50, 1, '978-0134686097');
