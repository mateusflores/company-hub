package br.unesp.mateusflores.companyhubapp.application.mappers.impl;

import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyAddressCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyAddressSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyAddressMapper;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;
import org.springframework.stereotype.Component;

@Component
public class CompanyAddressMapperImpl implements CompanyAddressMapper {
    @Override
    public CompanyAddress toEntity(CompanyAddressCreateRequestDTO dto) {
        return CompanyAddress.builder()
                .postalCode(dto.postalCode())
                .street(dto.street())
                .number(dto.number())
                .neighborhood(dto.neighborhood())
                .city(dto.city())
                .state(dto.state())
                .country(dto.country())
                .build();
    }

    @Override
    public CompanyAddressSummaryDTO toSummaryDTO(CompanyAddress entity) {
        return new CompanyAddressSummaryDTO(
                entity.getId(),
                entity.getPostalCode(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getCountry(),
                entity.getCompany().getId()
        );
    }
}
