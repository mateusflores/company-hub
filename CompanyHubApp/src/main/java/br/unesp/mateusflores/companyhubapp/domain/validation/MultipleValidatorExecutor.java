package br.unesp.mateusflores.companyhubapp.domain.validation;

import br.unesp.mateusflores.companyhubapp.domain.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleValidatorExecutor {
    private final List<Validator> validators;

    private MultipleValidatorExecutor(List<Validator> validators) {
        this.validators = validators;
    }

    public static MultipleValidatorExecutor of(Validator... validators) {
        return new MultipleValidatorExecutor(Arrays.asList(validators));
    }

    public static MultipleValidatorExecutor of(List<Validator> validators) {
        return new MultipleValidatorExecutor(validators);
    }

    public void validateAll() throws ValidationException {
        List<FieldError> errorList = new ArrayList<>();
        for (Validator validator : validators) {
            var error = validator.validate();
            if (error != null) {
                errorList.add(error);
            }
        }
        if (!errorList.isEmpty()) {
            throw new ValidationException(errorList);
        }
    }
}
