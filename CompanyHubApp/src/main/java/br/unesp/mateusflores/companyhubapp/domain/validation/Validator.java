package br.unesp.mateusflores.companyhubapp.domain.validation;

public interface Validator {
    FieldError validate();

    static Validator of(Boolean condition, String name, String description) {
        return () -> condition ? null : new FieldError(name, description);
    }
}
