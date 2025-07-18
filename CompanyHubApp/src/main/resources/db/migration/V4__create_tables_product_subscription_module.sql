CREATE TABLE module
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    module_name        VARCHAR(255)                            NOT NULL,
    module_description VARCHAR(255),
    base_price         DECIMAL(19, 2)                          NOT NULL,
    product_id         BIGINT                                  NOT NULL,
    is_main_module     BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk_module PRIMARY KEY (id)
);

CREATE TABLE products
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    product_name        VARCHAR(255)                            NOT NULL,
    product_description VARCHAR(255),
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE subscription
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    product_id          BIGINT                                  NOT NULL,
    company_id          UUID                                    NOT NULL,
    discount_percentage DECIMAL(19, 2),
    valid_until         date,
    is_valid            BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk_subscription PRIMARY KEY (id)
);

CREATE TABLE subscription_module
(
    module_id       BIGINT NOT NULL,
    subscription_id BIGINT NOT NULL,
    CONSTRAINT pk_subscription_module PRIMARY KEY (module_id, subscription_id)
);

ALTER TABLE client_accounts
    ADD CONSTRAINT uc_client_accounts_username UNIQUE (username);

ALTER TABLE companies
    ADD CONSTRAINT uc_companies_cnpj UNIQUE (cnpj);

ALTER TABLE module
    ADD CONSTRAINT uc_module_module_name UNIQUE (module_name);

ALTER TABLE products
    ADD CONSTRAINT uc_products_product_name UNIQUE (product_name);

ALTER TABLE module
    ADD CONSTRAINT FK_MODULE_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE subscription
    ADD CONSTRAINT FK_SUBSCRIPTION_ON_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id);

ALTER TABLE subscription
    ADD CONSTRAINT FK_SUBSCRIPTION_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE subscription_module
    ADD CONSTRAINT fk_submod_on_module FOREIGN KEY (module_id) REFERENCES module (id);

ALTER TABLE subscription_module
    ADD CONSTRAINT fk_submod_on_subscription FOREIGN KEY (subscription_id) REFERENCES subscription (id);