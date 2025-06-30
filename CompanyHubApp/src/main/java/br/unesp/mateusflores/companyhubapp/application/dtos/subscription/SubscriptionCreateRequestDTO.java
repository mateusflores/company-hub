package br.unesp.mateusflores.companyhubapp.application.dtos.subscription;

import java.math.BigDecimal;
import java.util.Set;

public record SubscriptionCreateRequestDTO(
        Long productId,
        Long companyId,
        Set<Long> modulesId,
        BigDecimal discountPercentage
) {
}
