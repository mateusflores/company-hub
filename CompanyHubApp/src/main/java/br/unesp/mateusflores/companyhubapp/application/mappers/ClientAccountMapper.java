package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccountSummaryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClientAccountMapper {


    ClientAccount toClientAccount(ClientAccountSummaryDTO dto);

    ClientAccount toClientAccount(ClientAccountCreateRequestDTO dto);

    @Mapper(uses = CompanyMapper.class)
    ClientAccountSummaryDTO toClientAccountSummaryDto(ClientAccount clientAccount);

    ClientAccountCreateRequestDTO toClientAccountRequestDto(ClientAccount clientAccount);

}
