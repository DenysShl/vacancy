create table vacansions
(
    id         SERIAL PRIMARY KEY NOT NULL,
    department VARCHAR(120)       NOT NULL,
    dyrekcija  VARCHAR(120)       NOT NULL,
    viddil     VARCHAR(120)       NOT NULL,
    posada     VARCHAR(120)       NOT NULL,
    quantity   int,
    created_on TIMESTAMP,
    status     BOOLEAN            NOT NULL
);

ALTER TABLE vacansions
    OWNER to postgres;