package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanySummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.services.GenericCrudService;
import br.unesp.mateusflores.companyhubapp.domain.company.Company;
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
@RequestMapping(value = "api/v1/company")
public class CompanyController extends GenericCRUDControllerAbstract<Company, UUID,
        CompanyCreateRequestDTO, CompanyUpdateRequestDTO, CompanySummaryDTO> {

    public CompanyController(GenericCrudService<UUID, CompanyCreateRequestDTO,
            CompanyUpdateRequestDTO, CompanySummaryDTO> genericCrudService) {
        super(genericCrudService);
    }

    @Override
    @PostMapping
    public ResponseEntity<CompanySummaryDTO> create(@Valid @RequestBody CompanyCreateRequestDTO companyCreateRequestDTO) {
        var response = genericCrudService.create(companyCreateRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<CompanySummaryDTO>>> findAll(Pageable pageable, PagedResourcesAssembler<CompanySummaryDTO> assembler) {
        return super.findAll(pageable, assembler);
    }

    @Override
    @GetMapping("/{uuid}")
    public ResponseEntity<CompanySummaryDTO> findById(@PathVariable @Valid UUID uuid) {
        return super.findById(uuid);
    }

    @Override
    @PutMapping("/{uuid}")
    public ResponseEntity<CompanySummaryDTO> update(@Valid @PathVariable UUID uuid,
                                                    @Valid @RequestBody CompanyUpdateRequestDTO companyUpdateRequestDTO) {
        return super.update(uuid, companyUpdateRequestDTO);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable UUID uuid) {
        return super.deleteById(uuid);
    }
}
