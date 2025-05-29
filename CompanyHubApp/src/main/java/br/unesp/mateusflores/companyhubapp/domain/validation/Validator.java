package br.unesp.mateusflores.companyhubapp.domain.validation;

public interface Validator {
    FieldError validade();

    static Validator of(Boolean condition, String name, String description) {
        return () -> condition ? null : new FieldError(name, description);
    }
}
