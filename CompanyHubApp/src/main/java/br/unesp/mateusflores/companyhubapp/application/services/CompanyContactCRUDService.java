package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactUpdateRequest;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyContactMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.CompanyContactRepository;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyContactCRUDService extends GenericCrudServiceImpl<CompanyContact, UUID,
        CompanyContactCreateRequestDTO, CompanyContactUpdateRequest, CompanyContactSummaryDTO> {

    public CompanyContactCRUDService(CompanyContactRepository repository, CompanyContactMapper mapper) {
        super(repository, mapper);
    }
}
