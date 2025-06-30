package br.unesp.mateusflores.companyhubapp.application.dtos.subscription;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SubscriptionUpdateRequestDTO (
        Long subscriptionId,
        BigDecimal discountPercentage,
        Boolean isValid,
        LocalDate validUntil
){
}
