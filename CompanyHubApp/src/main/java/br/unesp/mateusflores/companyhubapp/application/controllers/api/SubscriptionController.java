package br.unesp.mateusflores.companyhubapp.application.controllers.api;

import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.services.SubscriptionCRUDService;
import br.unesp.mateusflores.companyhubapp.domain.subscription.Subscription;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/subscriptions")
public class SubscriptionController extends GenericCRUDControllerAbstract<Subscription, Long,
        SubscriptionCreateRequestDTO, SubscriptionUpdateRequestDTO, SubscriptionSummaryResponseDTO>{

    public SubscriptionController(SubscriptionCRUDService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<SubscriptionSummaryResponseDTO> create(@Valid @RequestBody SubscriptionCreateRequestDTO subscriptionCreateRequestDTO) {
        return super.create(subscriptionCreateRequestDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<SubscriptionSummaryResponseDTO>>> findAll(Pageable pageable, PagedResourcesAssembler<SubscriptionSummaryResponseDTO> assembler) {
        return super.findAll(pageable, assembler);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<SubscriptionSummaryResponseDTO> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<SubscriptionSummaryResponseDTO> update(Long id, @Valid SubscriptionUpdateRequestDTO subscriptionUpdateRequestDTO) {
        return super.update(id, subscriptionUpdateRequestDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return super.deleteById(id);
    }
}
