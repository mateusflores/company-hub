package br.unesp.mateusflores.companyhubapp.adapters.model.datamodel;

import br.unesp.mateusflores.companyhubapp.domain.entities.Company;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "client_account", schema = "ch")
public class ClientAccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 20, name = "identifier", nullable = false)
    private String identifier;
    private Set<Company> companies;

    public ClientAccountModel() {
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
