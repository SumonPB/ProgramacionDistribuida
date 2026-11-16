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

create table book_author
(
    books_isbn varchar(255) not null
        constraint book_author_books_isbn_fk
            references books
            on delete cascade,
    authors_id bigint       not null
        constraint book_author_authors_id_fk
            references authors
            on delete cascade,
    constraint book_author_pk
        primary key (books_isbn, authors_id)
);

alter table book_author
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

