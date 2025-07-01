package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleInProductResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductInModuleResponseDTO;
import br.unesp.mateusflores.companyhubapp.domain.product.Module;
import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface ModuleMapper extends GenericMapper<Module, ModuleCreateRequestDTO,
        ModuleUpdateRequestDTO, ModuleSummaryResponseDTO> {

    @Override
    ModuleSummaryResponseDTO entityToResponseDto(Module entity);

    ModuleInProductResponseDTO toInProductDto(Module entity);

    ProductInModuleResponseDTO productToInModuleDto(Product product);

}
