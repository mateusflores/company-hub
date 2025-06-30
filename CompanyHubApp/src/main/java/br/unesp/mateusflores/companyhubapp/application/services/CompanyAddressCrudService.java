package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressUpdateRequest;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyAddressMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.CompanyAddressRepository;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyAddressCrudService extends GenericCrudServiceImpl<CompanyAddress, UUID,
        CompanyAddressCreateRequestDTO, CompanyAddressUpdateRequest, CompanyAddressSummaryDTO>{

    public CompanyAddressCrudService(CompanyAddressRepository repository, CompanyAddressMapper mapper) {
        super(repository, mapper);
    }
}
