package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressUpdateRequest;
import br.unesp.mateusflores.companyhubapp.application.services.GenericCrudService;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "api/v1/company-address")
public class CompanyAddressController extends GenericCRUDControllerAbstract<CompanyAddress, UUID,
        CompanyAddressCreateRequestDTO, CompanyAddressUpdateRequest, CompanyAddressSummaryDTO>{

    @Autowired
    public CompanyAddressController(GenericCrudService<UUID, CompanyAddressCreateRequestDTO, CompanyAddressUpdateRequest, CompanyAddressSummaryDTO> crudService) {
        super(crudService);
    }

    @Override
    @PostMapping
    public ResponseEntity<CompanyAddressSummaryDTO> create(@Valid @RequestBody CompanyAddressCreateRequestDTO companyAddressCreateRequestDTO) {
        var response = genericCrudService.create(companyAddressCreateRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<CompanyAddressSummaryDTO>>> findAll(Pageable pageable,
                                                                                     PagedResourcesAssembler<CompanyAddressSummaryDTO> assembler) {
        return super.findAll(pageable, assembler);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CompanyAddressSummaryDTO> findById(@PathVariable @Valid UUID id) {
        return super.findById(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CompanyAddressSummaryDTO> update(@Valid @PathVariable UUID id,
                                                           @Valid @RequestBody CompanyAddressUpdateRequest companyAddressUpdateRequest) {
        return super.update(id, companyAddressUpdateRequest);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        return super.deleteById(id);
    }
}
