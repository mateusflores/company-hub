package br.unesp.mateusflores.companyhubapp.application.dtos.module;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ModuleCreateRequestDTO(
        @NotBlank String moduleName,
        String moduleDescription,
        BigDecimal basePrice,
        Boolean isMainModule,
        Long productId
) {
}
