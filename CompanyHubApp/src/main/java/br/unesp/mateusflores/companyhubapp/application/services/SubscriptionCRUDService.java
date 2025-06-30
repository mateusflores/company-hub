package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.SubscriptionMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.CompanyRepository;
import br.unesp.mateusflores.companyhubapp.application.repositories.ModuleRepository;
import br.unesp.mateusflores.companyhubapp.application.repositories.ProductRepository;
import br.unesp.mateusflores.companyhubapp.application.repositories.SubscriptionRepository;
import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.domain.product.Module;
import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import br.unesp.mateusflores.companyhubapp.domain.subscription.Subscription;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubscriptionCRUDService extends GenericCrudServiceImpl<Subscription, Long, SubscriptionCreateRequestDTO,
        SubscriptionUpdateRequestDTO, SubscriptionSummaryResponseDTO> {

    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public SubscriptionCRUDService(SubscriptionRepository repository, SubscriptionMapper mapper, CompanyRepository companyRepository, ProductRepository productRepository, ModuleRepository moduleRepository) {
        super(repository, mapper);
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    @Transactional
    public SubscriptionSummaryResponseDTO create(SubscriptionCreateRequestDTO subscriptionCreateRequestDTO) {
        Company company = companyRepository.findById(subscriptionCreateRequestDTO.companyId())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa com ID "
                        + subscriptionCreateRequestDTO.companyId() + " não encontrada."));

        Product product = productRepository.findById(subscriptionCreateRequestDTO.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID "
                        + subscriptionCreateRequestDTO.productId() + " não encontrado"));

        Subscription subscription = new Subscription();
        subscription.setCompany(company);
        subscription.setProduct(product);
        subscription.setDiscountPercentage(subscriptionCreateRequestDTO.discountPercentage());

        for (Long moduleId : subscriptionCreateRequestDTO.modulesId()) {
            Module module = moduleRepository.findById(moduleId)
                    .orElseThrow(() -> new ResourceNotFoundException("Módulo com ID " + moduleId + " não encontrado."));
            subscription.getModules().add(module);
        }

        return mapper.entityToResponseDto(repository.save(subscription));
    }

    @Override
    @Transactional
    public SubscriptionSummaryResponseDTO update(Long id, SubscriptionUpdateRequestDTO subscriptionUpdateRequestDTO) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assinatura com ID " + id + " não encontrada."));

        subscription.setDiscountPercentage(subscriptionUpdateRequestDTO.discountPercentage());
        subscription.setIsValid(subscriptionUpdateRequestDTO.isValid());
        subscription.setValidUntil(subscriptionUpdateRequestDTO.validUntil());

        return mapper.entityToResponseDto(repository.save(subscription));
    }
}
