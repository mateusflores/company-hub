package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanySummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.company.CompanyUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends GenericMapper<Company, CompanyCreateRequestDTO,
        CompanyUpdateRequestDTO, CompanySummaryDTO> {
}
