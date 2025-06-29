package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactUpdateRequest;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyContactMapper extends GenericMapper<CompanyContact, CompanyContactCreateRequestDTO,
        CompanyContactUpdateRequest, CompanyContactSummaryDTO>{
}
