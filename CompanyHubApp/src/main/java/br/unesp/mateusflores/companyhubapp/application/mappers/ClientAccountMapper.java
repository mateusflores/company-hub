package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientAccountMapper extends GenericMapper<ClientAccount, ClientAccountCreateRequestDTO,
        ClientAccountUpdateRequestDTO, ClientAccountSummaryDTO>{

}
