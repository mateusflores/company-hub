CREATE TABLE ch.company_address
(
    address_id   UUID PRIMARY KEY,
    postal_code  VARCHAR(20)  NOT NULL,
    street       VARCHAR(255),
    number       VARCHAR(20)  NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    city         VARCHAR(100) NOT NULL,
    state        VARCHAR(100) NOT NULL,
    country      VARCHAR(100) NOT NULL,
    company_id   UUID         NOT NULL,
    FOREIGN KEY (company_id) REFERENCES ch.company (company_id)
);