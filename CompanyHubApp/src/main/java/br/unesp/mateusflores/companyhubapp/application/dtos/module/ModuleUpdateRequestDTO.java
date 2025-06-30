package br.unesp.mateusflores.companyhubapp.application.dtos.module;

import java.math.BigDecimal;

public record ModuleUpdateRequestDTO(
        Long id,
        String moduleName,
        String moduleDescription,
        BigDecimal basePrice,
        Boolean isMainModule
) {
}
