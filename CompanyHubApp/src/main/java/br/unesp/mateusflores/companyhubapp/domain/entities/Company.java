package br.unesp.mateusflores.companyhubapp.domain.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class Company {
    private UUID id;
    private String cnpj;
    private String companyName;
    private String tradingName;
    private LocalDate registrationDate;
    private ClientAccount clientAccount;
    private Set<CompanyAddress> addresses;
    private Set<CompanyContact> contacts;

    public Company() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    public Set<CompanyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<CompanyAddress> addresses) {
        this.addresses = addresses;
    }

    public Set<CompanyContact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<CompanyContact> contacts) {
        this.contacts = contacts;
    }
}
