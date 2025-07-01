package br.unesp.mateusflores.companyhubapp.application.controllers.web;

import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanySummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.AddressWithoutCompanyIdCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.ContactWithoutCompanyIdCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.services.ClientAccountCRUDService;
import br.unesp.mateusflores.companyhubapp.application.services.CompanyCRUDService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/web/companies")
public class CompanyWebController {

    private final CompanyCRUDService companyService;
    private final ClientAccountCRUDService clientAccountService; // Precisamos dele para o dropdown

    public CompanyWebController(CompanyCRUDService companyService, ClientAccountCRUDService clientAccountService) {
        this.companyService = companyService;
        this.clientAccountService = clientAccountService;
    }

    // 1. Mostra a página de listagem paginada
    @GetMapping
    public String listCompanies(Pageable pageable, Model model) {
        Page<CompanySummaryDTO> companyPage = companyService.findAll(pageable);
        model.addAttribute("companyPage", companyPage);
        return "company/list";
    }

    // 2. Mostra a página de formulário para uma NOVA empresa
// Em CompanyWebController.java
    @GetMapping("/new")
    public String showNewCompanyForm(Model model) {
        // Precisamos inicializar com listas contendo um objeto vazio para o binding funcionar
        var createDto = new CompanyCreateRequestDTO(
                null, "", "", "", LocalDate.now(),
                List.of(new ContactWithoutCompanyIdCreateRequestDTO("", "", "", "", "", "")), // Lista com um contato vazio
                List.of(new AddressWithoutCompanyIdCreateRequestDTO("", "", "", "", "", "", "")), // Lista com um endereço vazio
                null
        );
        model.addAttribute("companyDTO", createDto);
        model.addAttribute("clientAccounts", clientAccountService.findAll(Pageable.unpaged()).getContent());
        return "company/form";
    }

    // 3. PROCESSA a criação de uma nova empresa
    @PostMapping("/create")
    public String createCompany(@Valid @ModelAttribute("companyDTO") CompanyCreateRequestDTO dto,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Se houver erro, precisa carregar a lista de contas novamente para renderizar o form
            model.addAttribute("clientAccounts", clientAccountService.findAll(Pageable.unpaged()).getContent());
            return "company/form";
        }
        companyService.create(dto);
        return "redirect:/web/companies";
    }

    // Adicione os métodos para EDITAR aqui quando for implementar
    // GET /{id}/edit
    // POST /{id}/edit
}