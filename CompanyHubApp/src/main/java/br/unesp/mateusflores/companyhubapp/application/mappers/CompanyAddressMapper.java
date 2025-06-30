package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.AddressWithoutCompanyIdCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressUpdateRequest;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyAddressMapper extends GenericMapper<CompanyAddress, CompanyAddressCreateRequestDTO,
        CompanyAddressUpdateRequest, CompanyAddressSummaryDTO> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "version", ignore = true)
    CompanyAddress createDtoToEntity(AddressWithoutCompanyIdCreateRequestDTO dto);
}
