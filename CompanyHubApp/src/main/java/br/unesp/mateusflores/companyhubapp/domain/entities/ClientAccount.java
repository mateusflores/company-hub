package br.unesp.mateusflores.companyhubapp.domain.entities;

import br.unesp.mateusflores.companyhubapp.domain.validation.MultipleValidatorExecutor;
import br.unesp.mateusflores.companyhubapp.domain.validation.Validator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ClientAccount {
    private final UUID id;
    private final String identifier;
    private final Set<Company> companies;

    public ClientAccount(UUID id, String identifier, Set<Company> companies) {
        this.id = id;
        this.identifier = identifier;
        this.companies = companies;
    }

    public UUID getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public static class ClientAccountBuilder {
        private UUID id;
        private String identifier = "";
        private Set<Company> companies = new HashSet<>();

        public ClientAccountBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public ClientAccountBuilder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public ClientAccountBuilder setCompanies(Set<Company> companies) {
            this.companies = companies;
            return this;
        }

        public ClientAccount build() {
            MultipleValidatorExecutor executor = MultipleValidatorExecutor.of(
                    Validator.of(this.identifier != null && this.identifier.length() <= 20, "Identifier", "identifier must have at most 20 characters")
            );

            executor.validateAll();

            return new ClientAccount(this.id, this.identifier, this.companies);
        }
    }
}
