package br.unesp.mateusflores.companyhubapp.application.dtos.companycontact;

import br.unesp.mateusflores.companyhubapp.application.util.RegexUtil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record ContactWithoutCompanyIdCreateRequestDTO(
        @NotEmpty String name,
        @Email String email,
        @Pattern(regexp = RegexUtil.BRAZILIAN_PHONE_REGEX, message = "Telefone fora do padrão") String phone,
        @Pattern(regexp = RegexUtil.BRAZILIAN_PHONE_REGEX, message = "Telefone alternativo fora do padrão") String alternatePhone,
        String department,
        String notes
) {
}
