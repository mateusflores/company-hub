package br.unesp.mateusflores.companyhubapp.application.dtos;

import java.util.UUID;

public record CompanyAddressSummaryDTO(
        UUID id,
        String postalCode,
        String street,
        String number,
        String neighborhood,
        String city,
        String state,
        String country,
        UUID companyId
) {
}
