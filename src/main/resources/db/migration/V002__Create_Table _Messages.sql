create table messages
(
    id         SERIAL PRIMARY KEY NOT NULL,
    email      VARCHAR(120)       NOT NULL,
    tel        VARCHAR(12)        NOT NULL,
    message    VARCHAR(255)       NOT NULL,
    created_on TIMESTAMP          NOT NULL
);

ALTER TABLE messages
    OWNER to postgres;