package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.CompanyContactUpdateRequest;
import br.unesp.mateusflores.companyhubapp.application.dtos.companycontact.ContactWithoutCompanyIdCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyContactMapper extends GenericMapper<CompanyContact, CompanyContactCreateRequestDTO,
        CompanyContactUpdateRequest, CompanyContactSummaryDTO>{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "version", ignore = true)
    CompanyContact createDtoToEntity(ContactWithoutCompanyIdCreateRequestDTO dto);

}
