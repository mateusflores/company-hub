package br.unesp.mateusflores.companyhubapp.application.controllers.web;

import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ClientAccountMapper;
import br.unesp.mateusflores.companyhubapp.application.services.ClientAccountCRUDService;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/web/client-account")
public class ClientAccountWebController {
    private final ClientAccountCRUDService clientAccountService;
    private final ClientAccountMapper clientAccountMapper;

    public ClientAccountWebController(ClientAccountCRUDService clientAccountService, ClientAccountMapper clientAccountMapper) {
        this.clientAccountService = clientAccountService;
        this.clientAccountMapper = clientAccountMapper;
    }

    // 1. Mostra a página principal com a tabela paginada
    @GetMapping
    public String listClientAccounts(org.springframework.data.domain.Pageable pageable, Model model) {
        Page<ClientAccountSummaryDTO> page = clientAccountService.findAll(pageable);
        model.addAttribute("clientAccountPage", page);
        return "client-account/list";
    }

    // 2. Fornece o formulário para um NOVO cliente (retorna só o fragmento HTML)
    @GetMapping("/new")
    public String showNewClientAccountForm(Model model) {
        model.addAttribute("clientAccountDTO", new ClientAccountCreateRequestDTO("", ""));
        model.addAttribute("actionUrl", "/web/client-accounts/create");
        return "client-account/form-fragment :: form"; // Retorna SÓ o pedaço do formulário
    }

    // 3. Fornece o formulário para EDITAR um cliente (retorna o mesmo fragmento, mas com dados)
    @GetMapping("/{id}/edit")
    public String showEditClientAccountForm(@PathVariable UUID id, Model model) {
        ClientAccountSummaryDTO dto = clientAccountService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        model.addAttribute("clientAccountDTO", clientAccountMapper.summaryDtoToUpdateRequestDto(dto)); // Supondo um mapper
        model.addAttribute("actionUrl", "/web/client-accounts/" + id + "/edit");
        return "client-account/form-fragment :: form";
    }

    // 4. PROCESSA a criação de um novo cliente
    @PostMapping("/create")
    public String createClientAccount(@Valid @ModelAttribute("clientAccountDTO") ClientAccountCreateRequestDTO dto,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("actionUrl", "/web/client-accounts/create");
            return "client-account/form-fragment :: form"; // Retorna o form com erros de validação
        }
        clientAccountService.create(dto);
        // Após salvar, retorna a tabela atualizada para o htmx
        return listClientAccounts(Pageable.ofSize(5), model); // Retorna a primeira página da tabela
    }

    // 5. PROCESSA a atualização de um cliente
    @PostMapping("/{id}/edit")
    public String updateClientAccount(@PathVariable UUID id, @Valid @ModelAttribute("clientAccountDTO") ClientAccountUpdateRequestDTO dto,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("actionUrl", "/web/client-accounts/" + id + "/edit");
            return "client-account/form-fragment :: form";
        }
        clientAccountService.update(id, dto);
        return listClientAccounts(Pageable.ofSize(5), model);
    }
}
