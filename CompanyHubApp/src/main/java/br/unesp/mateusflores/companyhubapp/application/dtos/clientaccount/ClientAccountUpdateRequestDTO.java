package br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ClientAccountUpdateRequestDTO(
        UUID id,
        @NotBlank @Size(max = 50, message = "Username deve ter menos de 50 caracteres") String userName,
        @NotBlank @Size(max = 100, message = "Identificador de cliente deve ter menos de 100 caracteres") String identifier
) {
}
