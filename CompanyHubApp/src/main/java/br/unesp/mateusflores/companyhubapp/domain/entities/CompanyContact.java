package br.unesp.mateusflores.companyhubapp.domain.entities;

import br.unesp.mateusflores.companyhubapp.domain.validation.MultipleValidatorExecutor;
import br.unesp.mateusflores.companyhubapp.domain.validation.Validator;

import java.util.UUID;
import java.util.regex.Pattern;

public class CompanyContact {
    private final UUID id;
    private final String name;
    private final String email;
    private final String phone;
    private final String alternatePhone;
    private final String department;
    private final String notes;
    private final Company company;

    private CompanyContact(UUID id, String name, String email, String phone, String alternatePhone,
                                 String department, String notes, Company company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.alternatePhone = alternatePhone;
        this.department = department;
        this.notes = notes;
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public String getDepartment() {
        return department;
    }

    public String getNotes() {
        return notes;
    }

    public Company getCompany() {
        return company;
    }

    public static class CompanyContactBuilder {
        private UUID id;
        private String name = "";
        private String email = "";
        private String phone = "";
        private String alternatePhone = "";
        private String department = "";
        private String notes = "";
        private Company company;

        public CompanyContactBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public CompanyContactBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CompanyContactBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CompanyContactBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public CompanyContactBuilder setAlternatePhone(String alternatePhone) {
            this.alternatePhone = alternatePhone;
            return this;
        }

        public CompanyContactBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public CompanyContactBuilder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public CompanyContactBuilder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public CompanyContact build() {
            MultipleValidatorExecutor executor = MultipleValidatorExecutor.of(
                    Validator.of(this.name != null && !this.name.isBlank(), "Name", "Contact name is empty"),
                    Validator.of(this.name != null && this.name.length() <= 100, "Name", "Contact name must have less than 100 characters"),
                    Validator.of(this.email == null || this.email.length() <= 100, "Email", "Contact email must have less than 100 characters"),
                    Validator.of(Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
                            .matcher(this.email).matches(), "Email", "Invalid email address"),
                    Validator.of(this.company != null, "Company", "The contact is not associated with a valid company")
            );

            executor.validateAll();

            return new CompanyContact(this.id, this.name, this.email, this.phone, this.alternatePhone,
                    this.department, this.notes, this.company);
        }
    }
}
