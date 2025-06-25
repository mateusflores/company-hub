package br.unesp.mateusflores.companyhubapp.application.mappers.impl;

import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.CompanyContactMapper;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import org.springframework.stereotype.Component;

@Component
public class CompanyContactMapperImpl implements CompanyContactMapper {

    @Override
    public CompanyContact toEntity(CompanyContactCreateRequestDTO dto) {
        return CompanyContact.builder()
                .name(dto.name())
                .email(dto.email())
                .phone(dto.phone())
                .alternatePhone(dto.alternatePhone())
                .department(dto.department())
                .notes(dto.notes())
                .build();
    }

    @Override
    public CompanyContactSummaryDTO toSummaryDTO(CompanyContact entity) {
        return new CompanyContactSummaryDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAlternatePhone(),
                entity.getDepartment(),
                entity.getNotes(),
                entity.getCompany().getId()
        );
    }
}
