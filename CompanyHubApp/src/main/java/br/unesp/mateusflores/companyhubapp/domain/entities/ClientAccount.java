package br.unesp.mateusflores.companyhubapp.domain.entities;

import java.util.Set;
import java.util.UUID;

public class ClientAccount {
    private UUID id;
    private String identifier;
    private Set<Company> companies;

    public ClientAccount() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
