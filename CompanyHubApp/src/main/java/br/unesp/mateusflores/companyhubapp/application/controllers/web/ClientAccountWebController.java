package br.unesp.mateusflores.companyhubapp.application.controllers.web;

import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountFormDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountUpdateRequestDTO;
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
@RequestMapping("/web/client-accounts")
public class ClientAccountWebController {

    private final ClientAccountCRUDService clientAccountService;

    public ClientAccountWebController(ClientAccountCRUDService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    // 1. Mostra a página de listagem (sem alterações)
    @GetMapping
    public String listClientAccounts(Pageable pageable, Model model) {
        Page<ClientAccountSummaryDTO> page = clientAccountService.findAll(pageable);
        model.addAttribute("clientAccountPage", page);
        return "client-account/list";
    }

    // 2. Mostra a PÁGINA de formulário para um NOVO cliente
    @GetMapping("/new")
    public String showNewClientAccountForm(Model model) {
        model.addAttribute("clientAccountDTO", new ClientAccountFormDTO());
        model.addAttribute("formAction", "/web/client-accounts/create");
        return "client-account/form";
    }

    // 3. Mostra a PÁGINA de formulário para EDITAR um cliente
    @GetMapping("/{id}/edit")
    public String showEditClientAccountForm(@PathVariable UUID id, Model model) {
        ClientAccountSummaryDTO dto = clientAccountService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        // Converte o DTO de resumo para o DTO do formulário
        ClientAccountFormDTO formDTO = new ClientAccountFormDTO(dto.id(), dto.userName(), dto.identifier());
        model.addAttribute("clientAccountDTO", formDTO);
        model.addAttribute("formAction", "/web/client-accounts/" + id + "/edit");
        return "client-account/form";
    }

    // 4. PROCESSA a criação de um novo cliente
    @PostMapping("/create")
    public String createClientAccount(@Valid @ModelAttribute("clientAccountDTO") ClientAccountFormDTO dto,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formAction", "/web/client-accounts/create");
            return "client-account/form";
        }
        // Converte para o DTO de criação antes de passar para o serviço
        ClientAccountCreateRequestDTO createDTO = new ClientAccountCreateRequestDTO(dto.getUserName(), dto.getIdentifier());
        clientAccountService.create(createDTO);
        return "redirect:/web/client-accounts";
    }

    // 5. PROCESSA a atualização de um cliente
    @PostMapping("/{id}/edit")
    public String updateClientAccount(@PathVariable UUID id, @Valid @ModelAttribute("clientAccountDTO") ClientAccountFormDTO dto,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formAction", "/web/client-accounts/" + id + "/edit");
            return "client-account/form";
        }
        // Converte para o DTO de atualização antes de passar para o serviço
        ClientAccountUpdateRequestDTO updateDTO = new ClientAccountUpdateRequestDTO(id, dto.getUserName(), dto.getIdentifier());
        clientAccountService.update(id, updateDTO);
        return "redirect:/web/client-accounts";
    }
}