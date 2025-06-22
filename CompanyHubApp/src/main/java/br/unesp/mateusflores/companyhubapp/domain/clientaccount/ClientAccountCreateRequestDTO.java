package br.unesp.mateusflores.companyhubapp.domain.clientaccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientAccountCreateRequestDTO(
        @NotBlank @Size(max = 100, message = "Identificador de cliente deve ter menos de 100 caracteres") String identifier
) {
}
