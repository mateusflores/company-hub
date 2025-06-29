package br.unesp.mateusflores.companyhubapp.application.dtos.company;

import java.util.UUID;

public record CompanySummaryDTO(
        UUID id,
        String cnpj,
        String companyName,
        String tradingName
) {
}
