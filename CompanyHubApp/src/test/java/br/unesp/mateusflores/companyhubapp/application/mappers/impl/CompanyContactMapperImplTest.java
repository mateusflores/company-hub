package br.unesp.mateusflores.companyhubapp.application.mappers.impl;

import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyContactCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.CompanyContactSummaryDTO;
import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompanyContactMapperImplTest {

    private final CompanyContactMapperImpl mapper = new CompanyContactMapperImpl();

    @Test
    void deveConverterCreateRequestDTOParaEntidade() {
        UUID companyId = UUID.randomUUID();
        CompanyContactCreateRequestDTO dto = new CompanyContactCreateRequestDTO(
                "João",
                "joao@email.com",
                "11999999999",
                "11888888888",
                "Vendas",
                "Contato importante",
                companyId
        );

        CompanyContact entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals("João", entity.getName());
        assertEquals("joao@email.com", entity.getEmail());
        assertEquals("11999999999", entity.getPhone());
        assertEquals("11888888888", entity.getAlternatePhone());
        assertEquals("Vendas", entity.getDepartment());
        assertEquals("Contato importante", entity.getNotes());
        // O campo company não é setado pelo mapper
        assertNull(entity.getCompany());
    }

    @Test
    void deveConverterEntidadeParaSummaryDTO() {
        UUID companyId = UUID.randomUUID();
        UUID contactId = UUID.randomUUID();
        Company company = Company.builder().id(companyId).build();
        CompanyContact entity = CompanyContact.builder()
                .id(contactId)
                .name("Maria")
                .email("maria@email.com")
                .phone("11911111111")
                .alternatePhone("11777777777")
                .department("RH")
                .notes("RH principal")
                .company(company)
                .build();

        CompanyContactSummaryDTO dto = mapper.toSummaryDTO(entity);

        assertNotNull(dto);
        assertEquals(contactId, dto.id());
        assertEquals("Maria", dto.name());
        assertEquals("maria@email.com", dto.email());
        assertEquals("11911111111", dto.phone());
        assertEquals("11777777777", dto.alternatePhone());
        assertEquals("RH", dto.department());
        assertEquals("RH principal", dto.notes());
        assertEquals(companyId, dto.companyId());
    }

    @Test
    void deveLancarNullPointerSeCompanyForNuloEmToSummaryDTO() {
        CompanyContact entity = CompanyContact.builder()
                .id(UUID.randomUUID())
                .name("Sem Empresa")
                .company(null)
                .build();

        assertThrows(NullPointerException.class, () -> mapper.toSummaryDTO(entity));
    }
}