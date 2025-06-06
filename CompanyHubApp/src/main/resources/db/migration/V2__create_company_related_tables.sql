CREATE TABLE companyhub.client_accounts
(
    id         UUID         NOT NULL,
    version    BIGINT,
    identifier VARCHAR(255) NOT NULL,
    CONSTRAINT pk_client_accounts PRIMARY KEY (id)
);

CREATE TABLE companyhub.companies
(
    id                  UUID         NOT NULL,
    version             BIGINT,
    internal_identifier BIGINT,
    cnpj                VARCHAR(14)  NOT NULL,
    company_name        VARCHAR(255) NOT NULL,
    trading_name        VARCHAR(255),
    registration_date   date,
    client_account_id   UUID         NOT NULL,
    CONSTRAINT pk_companies PRIMARY KEY (id)
);

CREATE TABLE companyhub.company_adresses
(
    id           UUID NOT NULL,
    version      BIGINT,
    postal_code  VARCHAR(8),
    street       VARCHAR(255),
    number       VARCHAR(255),
    neighborhood VARCHAR(255),
    city         VARCHAR(255),
    state        VARCHAR(255),
    country      VARCHAR(255),
    company_id   UUID NOT NULL,
    CONSTRAINT pk_company_adresses PRIMARY KEY (id)
);

CREATE TABLE companyhub.company_contacts
(
    id              UUID NOT NULL,
    version         BIGINT,
    name            VARCHAR(255),
    email           VARCHAR(255),
    phone           VARCHAR(30),
    alternate_phone VARCHAR(255),
    department      VARCHAR(255),
    notes           VARCHAR(255),
    company_id      UUID NOT NULL,
    CONSTRAINT pk_company_contacts PRIMARY KEY (id)
);

ALTER TABLE companyhub.companies
    ADD CONSTRAINT FK_COMPANIES_ON_CLIENTACCOUNT FOREIGN KEY (client_account_id) REFERENCES companyhub.client_accounts (id);

ALTER TABLE companyhub.company_adresses
    ADD CONSTRAINT FK_COMPANY_ADRESSES_ON_COMPANY FOREIGN KEY (company_id) REFERENCES companyhub.companies (id);

ALTER TABLE companyhub.company_contacts
    ADD CONSTRAINT FK_COMPANY_CONTACTS_ON_COMPANY FOREIGN KEY (company_id) REFERENCES companyhub.companies (id);