package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactUpdateRequest;
import br.unesp.mateusflores.companyhubapp.application.services.GenericCrudService;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/company-contact")
public class CompanyContactController extends GenericCRUDControllerAbstract<CompanyContact, UUID,
        CompanyContactCreateRequestDTO, CompanyContactUpdateRequest, CompanyContactSummaryDTO>{

    public CompanyContactController(GenericCrudService<UUID, CompanyContactCreateRequestDTO,
            CompanyContactUpdateRequest, CompanyContactSummaryDTO> genericCrudService) {
        super(genericCrudService);
    }

    @Override
    @PostMapping
    public ResponseEntity<CompanyContactSummaryDTO> create(@Valid @RequestBody CompanyContactCreateRequestDTO companyContactCreateRequestDTO) {
        var response = genericCrudService.create(companyContactCreateRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<CompanyContactSummaryDTO>>> findAll(Pageable pageable, PagedResourcesAssembler<CompanyContactSummaryDTO> assembler) {
        return super.findAll(pageable, assembler);
    }

    @Override
    @GetMapping("/{uuid}")
    public ResponseEntity<CompanyContactSummaryDTO> findById(@PathVariable @Valid UUID uuid) {
        return super.findById(uuid);
    }

    @Override
    @PutMapping("/{uuid}")
    public ResponseEntity<CompanyContactSummaryDTO> update(@Valid @PathVariable UUID uuid,
                                                           @Valid @RequestBody CompanyContactUpdateRequest companyContactUpdateRequest) {
        return super.update(uuid, companyContactUpdateRequest);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable UUID uuid) {
        return super.deleteById(uuid);
    }
}
