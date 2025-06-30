package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ModuleMapper.class})
public interface ProductMapper extends GenericMapper<Product, ProductCreateRequestDTO,
        ProductUpdateRequestDTO, ProductSummaryResponseDTO> {
}
