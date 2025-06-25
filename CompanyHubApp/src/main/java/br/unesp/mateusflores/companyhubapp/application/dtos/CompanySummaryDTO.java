package br.unesp.mateusflores.companyhubapp.application.dtos;

import java.util.UUID;

public record CompanySummaryDTO(
        UUID id,
        String cnpj,
        String companyName,
        String tradingName
) {
}
