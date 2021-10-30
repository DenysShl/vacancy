create table vacansions
(
    id         SERIAL PRIMARY KEY NOT NULL,
    department VARCHAR(50)        NOT NULL,
    dyrekcija  VARCHAR(50)        NOT NULL,
    viddil     VARCHAR(50),
    posada     VARCHAR(100),
    quantity   INTEGER,
    created_on TIMESTAMP          NOT NULL,
    status     BOOLEAN            NOT NULL
);

ALTER TABLE vacansions
    OWNER to postgres;