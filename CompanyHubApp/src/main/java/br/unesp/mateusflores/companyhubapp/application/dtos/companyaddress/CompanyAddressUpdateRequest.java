package br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress;

import br.unesp.mateusflores.companyhubapp.application.util.RegexUtil;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record CompanyAddressUpdateRequest(
        UUID id,
        @Pattern(regexp = RegexUtil.BRAZILIAN_POSTAL_CODE_REGEX, message = "CEP fornecido inválido") String postalCode,
        String street,
        String number,
        String neighborhood,
        String city,
        String state,
        String country,
        UUID companyId
) {
}
