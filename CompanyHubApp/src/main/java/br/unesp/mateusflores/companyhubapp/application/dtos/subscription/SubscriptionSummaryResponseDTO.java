package br.unesp.mateusflores.companyhubapp.application.dtos.subscription;

import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanySummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductSummaryResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SubscriptionSummaryResponseDTO (
        Long id,
        ProductSummaryResponseDTO product,
        CompanySummaryDTO company,
        BigDecimal discountPercentage,
        LocalDate validUntil,
        Boolean isValid
) {
}
