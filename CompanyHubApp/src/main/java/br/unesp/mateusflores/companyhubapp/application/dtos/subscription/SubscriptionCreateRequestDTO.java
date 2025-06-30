package br.unesp.mateusflores.companyhubapp.application.dtos.subscription;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record SubscriptionCreateRequestDTO(
        Long productId,
        UUID companyId,
        Set<Long> modulesId,
        BigDecimal discountPercentage
) {
}
