package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.services.company.ClientAccountCRUDService;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public ResponseEntity<ClientAccountSummaryDTO> findById(@PathVariable @NotNull String id) {
        var summaryDto = crudService.findById(UUID.fromString(id)).orElseThrow(
                () -> new ResourceNotFoundException("Conta de cliente não encontrada.")
        );
        return ResponseEntity.ok(summaryDto);
    }

}
