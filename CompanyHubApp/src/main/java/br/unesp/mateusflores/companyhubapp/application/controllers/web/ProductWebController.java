package br.unesp.mateusflores.companyhubapp.application.controllers.web;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleFormDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductFormDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.product.ProductSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ProductMapper;
import br.unesp.mateusflores.companyhubapp.application.services.ProductCRUDService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/products")
public class ProductWebController {

    private final ProductCRUDService productService;
    private final ProductMapper productMapper;

    public ProductWebController(ProductCRUDService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    // 1. Mostra a página de listagem
    @GetMapping
    public String listProducts(Pageable pageable, Model model) {
        Page<ProductSummaryResponseDTO> productPage = productService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "product/list";
    }

    // 2. Mostra o formulário para um NOVO produto
// Em ProductWebController.java
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        ProductFormDTO formDTO = new ProductFormDTO();
        // Adiciona 2 módulos vazios para o formulário renderizar os campos
        formDTO.getModules().add(new ModuleFormDTO());
        formDTO.getModules().add(new ModuleFormDTO());
        model.addAttribute("productForm", formDTO);
        return "product/form";
    }

    // 3. PROCESSA a criação de um novo produto
    @PostMapping("/create")
    public String processCreationForm(@Valid @ModelAttribute("productForm") ProductFormDTO formDTO,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "product/form";
        }
        ProductCreateRequestDTO createDTO = productMapper.formDtoToCreateDto(formDTO);
        productService.create(createDTO);
        return "redirect:/web/products";
    }

    // Os métodos de EDIÇÃO (GET e POST) seguiriam o mesmo padrão dos outros controllers
}