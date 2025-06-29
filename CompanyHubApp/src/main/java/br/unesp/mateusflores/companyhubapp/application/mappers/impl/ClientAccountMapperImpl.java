package br.unesp.mateusflores.companyhubapp.application.mappers.impl;

import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanySummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ClientAccountMapper;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyMapper;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientAccountMapperImpl implements ClientAccountMapper {

    private final CompanyMapper companyMapper;

    @Autowired
    public ClientAccountMapperImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public ClientAccount createDtotoEntity(ClientAccountCreateRequestDTO dto) {
        return ClientAccount.builder()
                .userName(dto.userName())
                .identifier(dto.identifier())
                .build();
    }

    @Override
    public ClientAccountSummaryDTO toClientAccountSummaryDto(ClientAccount entity) {
        Set<CompanySummaryDTO> companies = new HashSet<>();
        if (entity.getCompanies() != null) {
            companies = entity.getCompanies().stream()
                    .map(companyMapper::toCompanySummaryDTO)
                    .collect(Collectors.toSet());
        }

        return new ClientAccountSummaryDTO(entity.getId(),
                entity.getUserName(),
                entity.getIdentifier(),
                companies
                );
    }

    @Override
    public ClientAccount updateDtotoEntity(ClientAccountUpdateRequestDTO dto) {
        return ClientAccount.builder()
                .id(dto.id())
                .identifier(dto.identifier())
                .userName(dto.userName())
                .build();
    }
}
