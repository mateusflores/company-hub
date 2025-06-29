package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.services.ClientAccountCRUDService;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/client-account")
public class ClientAccountController {
    private final ClientAccountCRUDService crudService;

    @Autowired
    public ClientAccountController(ClientAccountCRUDService crudService) {
        this.crudService = crudService;
    }

    @PostMapping
    public ResponseEntity<ClientAccountSummaryDTO> saveClientAccount(@Valid @RequestBody ClientAccountCreateRequestDTO dto) {
        var clientAccountSummaryDTO = crudService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientAccountSummaryDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(clientAccountSummaryDTO);
    }

    @GetMapping
    public HttpEntity<PagedModel<EntityModel<ClientAccountSummaryDTO>>> findAll(
            Pageable pageable, PagedResourcesAssembler<ClientAccountSummaryDTO> assembler) {
        Page<ClientAccountSummaryDTO> pages = crudService.findAll(pageable);
        return ResponseEntity.ok(assembler.toModel(pages));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientAccountSummaryDTO> findById(@PathVariable @NotNull String id) {
        var summaryDto = crudService.findById(UUID.fromString(id)).orElseThrow(
                () -> new ResourceNotFoundException("Conta de cliente não encontrada")
        );
        return ResponseEntity.ok().body(summaryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientAccountSummaryDTO> updateClientAccount(@PathVariable String id,
                                                                       @Valid @RequestBody ClientAccountUpdateRequestDTO dto) {
        var summaryDto = crudService.update(UUID.fromString(id), dto);
        return ResponseEntity.ok().body(summaryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable @NotNull UUID id) {
        if (!crudService.existsById(id)) throw new ResourceNotFoundException("ID informado não encontrado");
        crudService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
