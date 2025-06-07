package br.unesp.mateusflores.companyhubapp.domain.company;

import java.time.LocalDate;
import java.util.List;

public record CompanyCreateRequestDTO(
        Long internalIdentifier,
        String cnpj,
        String companyName,
        String tradingName,
        LocalDate registrationDate,
        List<CompanyContactCreateRequestDTO> contacts,
        List<CompanyAddressCreateRequestDTO> addresses,
        UUID
) {
}
