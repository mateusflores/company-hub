package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.module.ModuleUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ModuleMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.ModuleRepository;
import br.unesp.mateusflores.companyhubapp.domain.product.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleCRUDService extends GenericCrudServiceImpl<Module, Long, ModuleCreateRequestDTO,
        ModuleUpdateRequestDTO, ModuleSummaryResponseDTO>{

    @Autowired
    public ModuleCRUDService(ModuleRepository repository, ModuleMapper mapper) {
        super(repository, mapper);
    }

}
