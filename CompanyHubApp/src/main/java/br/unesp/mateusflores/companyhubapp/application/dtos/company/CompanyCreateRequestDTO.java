package br.unesp.mateusflores.companyhubapp.application.dtos.company;

import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.AddressWithoutCompanyIdCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.ContactWithoutCompanyIdCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.util.RegexUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CompanyCreateRequestDTO(
        Long internalIdentifier,
        @Pattern(regexp = RegexUtil.CNPJ_REGEX, message = "CNPJ informado inválido") String cnpj,
        @NotNull String companyName,
        String tradingName,
        @PastOrPresent LocalDate registrationDate,
        @Valid List<ContactWithoutCompanyIdCreateRequestDTO> contacts,
        @Valid List<AddressWithoutCompanyIdCreateRequestDTO> addresses,
        UUID clientAccountId
) {
}
