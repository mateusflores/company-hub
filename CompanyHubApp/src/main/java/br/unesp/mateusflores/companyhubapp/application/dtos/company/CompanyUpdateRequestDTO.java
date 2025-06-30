package br.unesp.mateusflores.companyhubapp.application.dtos.company;

import br.unesp.mateusflores.companyhubapp.application.util.RegexUtil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record CompanyUpdateRequestDTO(
        UUID id,
        Long internalIdentifier,
        @Pattern(regexp = RegexUtil.CNPJ_REGEX, message = "CNPJ informado inválido") String cnpj,
        @NotNull String companyName,
        String tradingName
) {
}
