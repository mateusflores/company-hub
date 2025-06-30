package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.services.GenericCrudService;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
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
@RequestMapping(value = "api/v1/client-account")
public class ClientAccountController extends GenericCRUDControllerAbstract<ClientAccount, UUID,
        ClientAccountCreateRequestDTO, ClientAccountUpdateRequestDTO, ClientAccountSummaryDTO> {

    public ClientAccountController(GenericCrudService<UUID, ClientAccountCreateRequestDTO, ClientAccountUpdateRequestDTO, ClientAccountSummaryDTO> genericCrudService) {
        super(genericCrudService);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClientAccountSummaryDTO> create(@Valid @RequestBody ClientAccountCreateRequestDTO dto) {
        var response = genericCrudService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ClientAccountSummaryDTO>>> findAll(Pageable pageable, PagedResourcesAssembler<ClientAccountSummaryDTO> assembler) {
        return super.findAll(pageable, assembler);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ClientAccountSummaryDTO> update(@Valid @PathVariable UUID id,
                                                          @Valid @RequestBody ClientAccountUpdateRequestDTO clientAccountUpdateRequestDTO) {
        return super.update(id, clientAccountUpdateRequestDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable UUID id) {
        return super.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClientAccountSummaryDTO> findById(@Valid @PathVariable UUID id) {
        return super.findById(id);
    }
}
