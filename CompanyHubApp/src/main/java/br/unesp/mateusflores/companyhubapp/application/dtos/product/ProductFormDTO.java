package br.unesp.mateusflores.companyhubapp.application.dtos.product;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleFormDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductFormDTO {

    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    private String productName;

    private String productDescription;

    @Valid
    private List<ModuleFormDTO> modules = new ArrayList<>();
}