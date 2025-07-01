package br.unesp.mateusflores.companyhubapp.application.dtos.module;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ModuleFormDTO {
    private Long id;
    @NotBlank
    private String moduleName;
    private String moduleDescription;
    @NotNull
    private BigDecimal basePrice;
    private Boolean isMainModule;
}
