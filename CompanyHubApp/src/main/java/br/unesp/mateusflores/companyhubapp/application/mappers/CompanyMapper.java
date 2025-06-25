package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanySummaryDTO;

public interface CompanyMapper {

    Company toEntity(CompanyCreateRequestDTO dto);

    CompanySummaryDTO toCompanySummaryDTO(Company entity);
}
