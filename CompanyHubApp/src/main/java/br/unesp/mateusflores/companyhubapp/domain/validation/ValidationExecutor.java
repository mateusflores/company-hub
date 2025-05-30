package br.unesp.mateusflores.companyhubapp.domain.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationExecutor {
    private final List<Validator> validators;

    private ValidationExecutor(List<Validator> validators) {
        this.validators = validators;
    }

    static ValidationExecutor of(List<Validator> validators) {
        return new ValidationExecutor(validators);
    }

    static ValidationExecutor of(Validator... validators) {
        return new ValidationExecutor(Arrays.asList(validators));
    }

    List<FieldError> validate() {
        List<FieldError> errors = new ArrayList<FieldError>();
        for (Validator validator : validators) {
            FieldError error = validator.validate();
            if (error != null) {
                errors.add(error);
            }
        }
        return errors;
    }
}
