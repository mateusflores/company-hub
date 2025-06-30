package br.unesp.mateusflores.companyhubapp.application.dtos.module;

import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductSummaryResponseDTO;

import java.math.BigDecimal;

public record ModuleSummaryResponseDTO(
        Long id,
        String moduleName,
        String moduleDescription,
        BigDecimal basePrice,
        ProductSummaryResponseDTO product,
        Boolean isMainModule
) {
}
