package br.unesp.mateusflores.companyhubapp.exceptions;

import java.time.Instant;

public record ApiErrorDTO(
        Instant timeStamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
