package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.companyaddress.CompanyAddressUpdateRequest;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyAddressMapper extends GenericMapper<CompanyAddress, CompanyAddressCreateRequestDTO,
        CompanyAddressUpdateRequest, CompanyAddressSummaryDTO> {

}
