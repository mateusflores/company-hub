package br.unesp.mateusflores.companyhubapp.application.dtos.subscription;

import java.util.Set;

public record AddModulesToSubscriptionRequestDTO(
        Long subscriptionId,
        Set<Long> modulesIdsToAdd
) {
}
