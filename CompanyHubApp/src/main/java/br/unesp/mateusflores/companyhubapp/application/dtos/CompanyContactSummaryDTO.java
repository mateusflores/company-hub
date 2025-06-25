package br.unesp.mateusflores.companyhubapp.application.dtos;

import java.util.UUID;

public record CompanyContactSummaryDTO(
        UUID id,
        String name,
        String email,
        String phone,
        String alternatePhone,
        String department,
        String notes,
        UUID companyId
) {
}
