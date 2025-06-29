package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountSummaryDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.clientaccount.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ClientAccountMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.ClientAccountRepository;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientAccountCRUDService extends GenericCrudServiceImpl<ClientAccount, UUID,
        ClientAccountCreateRequestDTO, ClientAccountUpdateRequestDTO, ClientAccountSummaryDTO> {

    public ClientAccountCRUDService(ClientAccountRepository repository, ClientAccountMapper mapper) {
        super(repository, mapper);
    }
}
