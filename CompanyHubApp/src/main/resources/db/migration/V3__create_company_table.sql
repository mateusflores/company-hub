CREATE TABLE ch.company
(
    company_id          UUID PRIMARY KEY,
    internal_identifier BIGINT UNIQUE,
    cnpj                VARCHAR(18)  NOT NULL,
    company_name        VARCHAR(100) NOT NULL,
    trading_name        VARCHAR(100),
    registration_date   DATE         NOT NULL,
    client_id           UUID         NOT NULL,
    FOREIGN KEY (client_id) REFERENCES ch.client_account (client_id)
);