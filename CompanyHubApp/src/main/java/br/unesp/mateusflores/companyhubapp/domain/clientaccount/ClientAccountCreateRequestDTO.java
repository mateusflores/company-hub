package br.unesp.mateusflores.companyhubapp.domain.clientaccount;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClientAccountCreateRequestDTO(
        @NotNull UUID id,
        @NotBlank @Max(value = 100) String identifier
) {
}
