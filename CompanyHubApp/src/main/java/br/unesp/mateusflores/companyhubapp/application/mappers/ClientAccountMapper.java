package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountSummaryDTO;

public interface ClientAccountMapper {

    ClientAccount toEntity(ClientAccountCreateRequestDTO dto);

    ClientAccountSummaryDTO toClientAccountSummaryDto(ClientAccount entity);

}
