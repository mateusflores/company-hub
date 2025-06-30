package br.unesp.mateusflores.companyhubapp.application.dtos.product;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleCreateRequestDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record ProductCreateRequestDTO(
        @NotBlank String productName,
        String productDescription,
        Set<ModuleCreateRequestDTO> modules
) {
}
