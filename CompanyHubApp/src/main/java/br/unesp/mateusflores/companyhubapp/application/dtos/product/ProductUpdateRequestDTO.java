package br.unesp.mateusflores.companyhubapp.application.dtos.product;

import jakarta.validation.constraints.NotBlank;

public record ProductUpdateRequestDTO(
        @NotBlank String productName,
        String productDescription
) {
}
