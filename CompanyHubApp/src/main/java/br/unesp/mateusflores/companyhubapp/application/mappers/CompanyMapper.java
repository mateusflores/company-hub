package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanySummaryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    Company toCompany(CompanySummaryDTO dto);

    CompanySummaryDTO toCompanySummaryDTO(Company company);
}
