create table employee
(
    id         SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(25)        NOT NULL,
    last_name  VARCHAR(50)        NOT NULL,
    email      VARCHAR(50)        not null,
    tel_number VARCHAR(18)       not null
);

ALTER TABLE employee
    OWNER to postgres;