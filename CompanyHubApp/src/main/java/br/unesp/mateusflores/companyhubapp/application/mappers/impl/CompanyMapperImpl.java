package br.unesp.mateusflores.companyhubapp.application.mappers.impl;

import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyAddressMapper;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyContactMapper;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyMapper;
import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanySummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CompanyMapperImpl implements CompanyMapper {

    private final CompanyContactMapper companyContactMapper;
    private final CompanyAddressMapper companyAddressMapper;

    @Autowired
    public CompanyMapperImpl(CompanyContactMapper companyContactMapper, CompanyAddressMapper companyAddressMapper) {
        this.companyContactMapper = companyContactMapper;
        this.companyAddressMapper = companyAddressMapper;
    }

    @Override
    public Company toEntity(CompanyCreateRequestDTO dto) {
        return Company.builder()
                .internalIdentifier(dto.internalIdentifier())
                .cnpj(dto.cnpj())
                .companyName(dto.companyName())
                .tradingName(dto.tradingName())
                .registrationDate(dto.registrationDate())
                .contacts(dto.contacts().stream().map(companyContactMapper::toEntity).collect(Collectors.toSet()))
                .addresses(dto.addresses().stream().map(companyAddressMapper::toEntity).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public CompanySummaryDTO toCompanySummaryDTO(Company company) {
        return null;
    }
}
