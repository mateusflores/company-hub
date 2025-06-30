package br.unesp.mateusflores.companyhubapp.application.dtos.product;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleSummaryResponseDTO;

import java.util.List;

public record ProductSummaryResponseDTO(
        Long id,
        String productName,
        String productDescription,
        List<ModuleSummaryResponseDTO> modules
) {
}
