CREATE TABLE ch.company_contact
(
    contact_id      UUID PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    email           VARCHAR(100),
    phone           VARCHAR(50),
    alternate_phone VARCHAR(50),
    department      VARCHAR(100),
    note            TEXT,
    company_id      UUID       NOT NULL,
    FOREIGN KEY (company_id) REFERENCES ch.company (company_id)
);