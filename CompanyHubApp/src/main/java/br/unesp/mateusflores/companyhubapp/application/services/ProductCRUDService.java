package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ModuleMapper;
import br.unesp.mateusflores.companyhubapp.application.mappers.ProductMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.ProductRepository;
import br.unesp.mateusflores.companyhubapp.domain.product.Module;
import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductCRUDService extends GenericCrudServiceImpl<Product, Long, ProductCreateRequestDTO,
        ProductUpdateRequestDTO, ProductSummaryResponseDTO> {

    private final ModuleMapper moduleMapper;

    @Autowired
    public ProductCRUDService(ProductRepository repository, ProductMapper mapper, ModuleMapper moduleMapper) {
        super(repository, mapper);
        this.moduleMapper = moduleMapper;
    }

    @Override
    public ProductSummaryResponseDTO create(ProductCreateRequestDTO productCreateRequestDTO) {
        Product product = new Product();
        product.setProductName(productCreateRequestDTO.productName());
        product.setProductDescription(productCreateRequestDTO.productDescription());

        Set<Module> modules = new HashSet<>();
        for (ModuleCreateRequestDTO moduleDTO : productCreateRequestDTO.modules()) {
            Module module = moduleMapper.createDtoToEntity(moduleDTO);
            module.setProduct(product);
            modules.add(module);
        }

        product.setModules(modules);

        return mapper.entityToResponseDto(repository.save(product));
    }
}
