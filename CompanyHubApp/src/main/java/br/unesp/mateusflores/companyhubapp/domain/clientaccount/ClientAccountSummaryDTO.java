package br.unesp.mateusflores.companyhubapp.domain.clientaccount;

import br.unesp.mateusflores.companyhubapp.domain.company.CompanySummaryDTO;

import java.util.List;
import java.util.UUID;

public record ClientAccountSummaryDTO(
        UUID id,
        String identifier,
        List<CompanySummaryDTO> companyList
) {
}
