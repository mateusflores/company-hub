package br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount;

import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanySummaryDTO;

import java.util.Set;
import java.util.UUID;

public record ClientAccountSummaryDTO(
        UUID id,
        String userName,
        String identifier,
        Set<CompanySummaryDTO> companyList
) {
}
