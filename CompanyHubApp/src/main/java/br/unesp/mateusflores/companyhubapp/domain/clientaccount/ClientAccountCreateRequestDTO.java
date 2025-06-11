package br.unesp.mateusflores.companyhubapp.domain.clientaccount;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record ClientAccountCreateRequestDTO(
        @NotBlank @Max(value = 100) String identifier
) {
}
