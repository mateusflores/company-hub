ALTER TABLE companyhub.client_accounts ADD CONSTRAINT unique_username UNIQUE (username);
ALTER TABLE companyhub.companies ADD CONSTRAINT unique_cnpj UNIQUE (cnpj);