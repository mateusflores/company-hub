package br.unesp.mateusflores.companyhubapp.domain.entities;

import br.unesp.mateusflores.companyhubapp.domain.validation.MultipleValidatorExecutor;
import br.unesp.mateusflores.companyhubapp.domain.validation.Validator;

import java.util.UUID;
import java.util.regex.Pattern;

public class CompanyAddress {
    private final UUID id;
    private final String postalCode;
    private final String street;
    private final String number;
    private final String neighborhood;
    private final String city;
    private final String state;
    private final String country;
    private final Company company;

    private CompanyAddress(UUID id, String postalCode, String street, String number, String neighborhood, String city, String state, String country, Company company) {
        this.id = id;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Company getCompany() {
        return company;
    }

    public static class CompanyAddressBuilder {
        private UUID id;
        private String postalCode = "";
        private String street = "";
        private String number = "";
        private String neighborhood = "";
        private String city = "";
        private String state = "";
        private String country = "";
        private Company company = null;

        public CompanyAddressBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public CompanyAddressBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public CompanyAddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public CompanyAddressBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public CompanyAddressBuilder setNeighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public CompanyAddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public CompanyAddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public CompanyAddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public CompanyAddressBuilder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public CompanyAddress build() {
            MultipleValidatorExecutor executor = MultipleValidatorExecutor.of(
                    Validator.of(this.postalCode != null && !this.postalCode.isBlank(), "PostalCode", "Postal code cannot be empty"),
                    Validator.of(this.postalCode != null && this.postalCode.length() <= 20, "PostalCode", "Postal code must be at most 20 characters"),
                    Validator.of(this.street != null && !this.street.isBlank(), "Street", "Street cannot be empty"),
                    Validator.of(this.street != null && this.street.length() <= 100, "Street", "Street must be at most 100 characters"),
                    Validator.of(this.number != null && !this.number.isBlank(), "Number", "Number cannot be empty"),
                    Validator.of(this.number != null && this.number.length() <= 20, "Number", "Number must be at most 20 characters"),
                    Validator.of(this.neighborhood != null && !this.neighborhood.isBlank(), "Neighborhood", "Neighborhood cannot be empty"),
                    Validator.of(this.neighborhood != null && this.neighborhood.length() <= 100, "Neighborhood", "Neighborhood must be at most 100 characters"),
                    Validator.of(this.city != null && !this.city.isBlank(), "City", "City cannot be empty"),
                    Validator.of(this.city != null && this.city.length() <= 100, "City", "City must be at most 100 characters"),
                    Validator.of(this.state != null && !this.state.isBlank(), "State", "State cannot be empty"),
                    Validator.of(this.state != null && this.state.length() <= 100, "State", "State must be at most 100 characters"),
                    Validator.of(this.country != null && !this.country.isBlank(), "Country", "Country cannot be empty"),
                    Validator.of(this.country != null && this.country.length() <= 100, "Country", "Country must be at most 100 characters"),
                    Validator.of(this.company != null, "Company", "The address is not associated with a valid company")
            );

            executor.validateAll();

            return new CompanyAddress(this.id, this.postalCode, this.street, this.number, this.neighborhood,
                    this.city, this.state, this.country, this.company);
        }
    }
}
