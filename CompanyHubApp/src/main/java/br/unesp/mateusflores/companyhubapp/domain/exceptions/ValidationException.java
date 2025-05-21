package br.unesp.mateusflores.companyhubapp.domain.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {

    public ValidationException(List<FieldError> errors) {
        super(buildErrorMessage(errors));
    }

    private static String buildErrorMessage(List<FieldError> errors) {
        var builder = new StringBuilder();
        builder.append("Validation failed for the following fields:\n");
        for (FieldError e: errors) {
            builder.append("Field: '");
            builder.append(e.field());
            builder.append("' - Error: ");
            builder.append(e.errorDescription());
            builder.append('\n');
        }
        return builder.toString();
    }
}
