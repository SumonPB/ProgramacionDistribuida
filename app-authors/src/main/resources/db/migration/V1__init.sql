
create table authors1
(
    id     serial not null  primary key ,
    name    varchar(255)
);

INSERT INTO authors1 ( name) OVERRIDING SYSTEM VALUE
VALUES ('Herbert Schildt');

INSERT INTO authors1 (name) OVERRIDING SYSTEM VALUE
VALUES ('Kathy Sierra');

INSERT INTO authors1 (name) OVERRIDING SYSTEM VALUE
VALUES ('Brian Goetz');

INSERT INTO authors1 (name) OVERRIDING SYSTEM VALUE
VALUES ('Robert C. Martin');