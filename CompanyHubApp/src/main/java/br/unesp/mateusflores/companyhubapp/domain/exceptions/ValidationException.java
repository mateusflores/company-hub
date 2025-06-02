package br.unesp.mateusflores.companyhubapp.domain.exceptions;

import br.unesp.mateusflores.companyhubapp.domain.validation.FieldError;

import java.util.List;

public class ValidationException extends RuntimeException {

    public ValidationException(List<FieldError> errors) {
        super(errorMessageBuilder(errors));
    }

    private static String errorMessageBuilder(List<FieldError> errors) {
        var builder = new StringBuilder();
        builder.append("Validation error at:\n");
        for (FieldError error : errors) {
            builder.append(error.name()).append(": ").append(error.errorDescription());
        }
        return builder.toString();
    }
}
