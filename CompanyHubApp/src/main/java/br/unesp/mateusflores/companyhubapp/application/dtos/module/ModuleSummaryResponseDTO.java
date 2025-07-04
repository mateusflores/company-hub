package br.unesp.mateusflores.companyhubapp.application.dtos.module;

import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductInModuleResponseDTO; // <-- MUDANÇA
import java.math.BigDecimal;

public record ModuleSummaryResponseDTO(
        Long id,
        String moduleName,
        String moduleDescription,
        BigDecimal basePrice,
        ProductInModuleResponseDTO product,
        Boolean isMainModule
) {
}