package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanySummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.ClientAccountRepository;
import br.unesp.mateusflores.companyhubapp.application.repositories.CompanyRepository;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CompanyCRUDService extends GenericCrudServiceImpl<Company, UUID, CompanyCreateRequestDTO, CompanyUpdateRequestDTO, CompanySummaryDTO>{

    private final ClientAccountRepository clientAccountRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyCRUDService(CompanyRepository repository, CompanyMapper mapper, ClientAccountRepository clientAccountRepository, CompanyMapper companyMapper) {
        super(repository, mapper);
        this.clientAccountRepository = clientAccountRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    @Transactional
    public CompanySummaryDTO create(CompanyCreateRequestDTO companyCreateRequestDTO) {
        ClientAccount clientAccount = clientAccountRepository.findById(companyCreateRequestDTO.clientAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID "
                        + companyCreateRequestDTO.clientAccountId() + " não encontrado."));

        Company company = companyMapper.createDtoToEntity(companyCreateRequestDTO);

        company.setClientAccount(clientAccount);

        if (!company.getContacts().isEmpty()) {
            company.getContacts().forEach(contact -> contact.setCompany(company));
        }

        if (!company.getAddresses().isEmpty()) {
            company.getAddresses().forEach(address -> address.setCompany(company));
        }

        return companyMapper.entityToResponseDto(repository.save(company));
    }

    @Override
    @Transactional
    public CompanySummaryDTO update(UUID uuid, CompanyUpdateRequestDTO companyUpdateRequestDTO) {

        Company company = repository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa com ID " + uuid + " não existe."));

        company.setInternalIdentifier(companyUpdateRequestDTO.internalIdentifier());
        company.setCnpj(companyUpdateRequestDTO.cnpj());
        company.setCompanyName(companyUpdateRequestDTO.companyName());
        company.setTradingName(companyUpdateRequestDTO.tradingName());

        return companyMapper.entityToResponseDto(repository.save(company));
    }
}
