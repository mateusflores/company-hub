package br.unesp.mateusflores.companyhubapp.domain.company;

import java.util.UUID;

public record CompanySummaryDTO(
        UUID id,
        String cnpj,
        String companyName,
        String tradingName
) {
}
