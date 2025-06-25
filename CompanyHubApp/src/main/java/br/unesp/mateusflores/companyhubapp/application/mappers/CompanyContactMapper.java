package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;

public interface CompanyContactMapper {

    CompanyContact toEntity(CompanyContactCreateRequestDTO dto);

    CompanyContactSummaryDTO toSummaryDTO(CompanyContact entity);
}
