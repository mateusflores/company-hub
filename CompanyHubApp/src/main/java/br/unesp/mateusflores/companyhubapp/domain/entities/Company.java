package br.unesp.mateusflores.companyhubapp.domain.entities;

import br.unesp.mateusflores.companyhubapp.domain.validation.MultipleValidatorExecutor;
import br.unesp.mateusflores.companyhubapp.domain.validation.Validator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Company {
    private final UUID id;
    private final Long internalIdentifier;
    private final String cnpj;
    private final String companyName;
    private final String tradingName;
    private final LocalDate registrationDate;
    private final Set<CompanyContact> contacts;
    private final Set<CompanyAddress> addresses;
    private final ClientAccount clientAccount;

    public Company(UUID id, Long internalIdentifier, String cnpj, String companyName, String tradingName, LocalDate registrationDate,
                   Set<CompanyContact> contacts, Set<CompanyAddress> addresses, ClientAccount clientAccount) {
        this.id = id;
        this.internalIdentifier = internalIdentifier;
        this.cnpj = cnpj;
        this.companyName = companyName;
        this.tradingName = tradingName;
        this.registrationDate = registrationDate;
        this.contacts = contacts;
        this.addresses = addresses;
        this.clientAccount = clientAccount;
    }

    public UUID getId() {
        return id;
    }

    public Long getInternalIdentifier() {
        return internalIdentifier;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Set<CompanyContact> getContacts() {
        return contacts;
    }

    public Set<CompanyAddress> getAddresses() {
        return addresses;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public static class CompanyBuilder {
        private UUID id;
        private Long internalIdentifier;
        private String cnpj = "";
        private String companyName = "";
        private String tradingName = "";
        private LocalDate registrationDate;
        private Set<CompanyContact> contacts = new HashSet<>();
        private Set<CompanyAddress> addresses = new HashSet<>();
        private ClientAccount clientAccount = null;

        public CompanyBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public CompanyBuilder setInternalIdentifier(Long internalIdentifier) {
            this.internalIdentifier = internalIdentifier;
            return this;
        }

        public CompanyBuilder setCnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public CompanyBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public CompanyBuilder setTradingName(String tradingName) {
            this.tradingName = tradingName;
            return this;
        }

        public CompanyBuilder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public CompanyBuilder setContacts(Set<CompanyContact> contacts) {
            this.contacts = contacts;
            return this;
        }

        public CompanyBuilder setAddresses(Set<CompanyAddress> addresses) {
            this.addresses = addresses;
            return this;
        }

        public CompanyBuilder setClientAccount(ClientAccount clientAccount) {
            this.clientAccount = clientAccount;
            return this;
        }

        public Company build() {
            MultipleValidatorExecutor executor = MultipleValidatorExecutor.of(
                    Validator.of(this.cnpj != null && !this.cnpj.isBlank(), "Cnpj", "CNPJ cannot be empty"),
                    Validator.of(this.cnpj != null && this.cnpj.length() <= 18, "Cnpj", "CNPJ must have at most 18 characters"),
                    Validator.of(this.companyName != null && !this.companyName.isBlank(), "CompanyName", "Company name cannot be empty"),
                    Validator.of(this.companyName != null && this.companyName.length() <= 100, "CompanyName", "Company name must have at most 100 characters"),
                    Validator.of(this.tradingName == null || this.tradingName.length() <= 100, "TradingName", "Trading name must have at most 100 characters"),
                    Validator.of(this.registrationDate != null, "RegistrationDate", "Registration date cannot be empty"),
                    Validator.of(this.registrationDate != null && !this.registrationDate.isAfter(LocalDate.now()), "RegistrationDate", "Registration date cannot be in the future"),
                    Validator.of(this.clientAccount != null, "ClientAccount", "Company must be associated with a client account")
            );

            executor.validateAll();

            return new Company(this.id, this.internalIdentifier, this.cnpj, this.companyName, this.tradingName,
                    this.registrationDate, this.contacts, this.addresses, this.clientAccount);
        }
    }
}
