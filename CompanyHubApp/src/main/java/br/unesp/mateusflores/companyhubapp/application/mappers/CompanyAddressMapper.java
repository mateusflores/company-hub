package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyAddressCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyAddressSummaryDTO;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;

public interface CompanyAddressMapper {

    CompanyAddress toEntity(CompanyAddressCreateRequestDTO dto);

    CompanyAddressSummaryDTO toSummaryDTO(CompanyAddress entity);
}
