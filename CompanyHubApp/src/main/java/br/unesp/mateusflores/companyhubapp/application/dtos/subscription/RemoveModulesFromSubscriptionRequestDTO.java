package br.unesp.mateusflores.companyhubapp.application.dtos.subscription;

import java.util.Set;

public record RemoveModulesFromSubscriptionRequestDTO(
        Long subscriptionId,
        Set<Long> modulesIdsToRemove
) {
}
