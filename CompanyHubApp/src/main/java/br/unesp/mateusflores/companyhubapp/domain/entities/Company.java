package br.unesp.mateusflores.companyhubapp.domain.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class Company {
    private UUID id;
    private Long internalIdentifier;
    private String cnpj;
    private String companyName;
    private String tradingName;
    private LocalDate registrationDate;
    private Set<CompanyContact> contacts;
    private Set<CompanyAddress> addresses;
    private ClientAccount clientAccount;

    public Company() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getInternalIdentifier() {
        return internalIdentifier;
    }

    public void setInternalIdentifier(Long internalIdentifier) {
        this.internalIdentifier = internalIdentifier;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<CompanyContact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<CompanyContact> contacts) {
        this.contacts = contacts;
    }

    public Set<CompanyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<CompanyAddress> addresses) {
        this.addresses = addresses;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }
}
