package br.unesp.mateusflores.companyhubapp.application.mappers.impl;

import br.unesp.mateusflores.companyhubapp.application.mappers.ClientAccountMapper;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyMapper;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClientAccountMapperImpl implements ClientAccountMapper {

    private final CompanyMapper companyMapper;

    @Autowired
    public ClientAccountMapperImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public ClientAccount toEntity(ClientAccountCreateRequestDTO dto) {
        return ClientAccount.builder()
                .userName(dto.userName())
                .identifier(dto.identifier())
                .build();
    }

    @Override
    public ClientAccountSummaryDTO toClientAccountSummaryDto(ClientAccount entity) {
        return new ClientAccountSummaryDTO(entity.getId(),
                entity.getUserName(),
                entity.getIdentifier(),
                entity.getCompanies().stream()
                        .map(companyMapper::toCompanySummaryDTO)
                        .collect(Collectors.toSet()));
    }
}
