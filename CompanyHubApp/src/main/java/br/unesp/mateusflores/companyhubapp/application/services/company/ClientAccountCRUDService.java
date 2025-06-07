package br.unesp.mateusflores.companyhubapp.application.services.company;

import br.unesp.mateusflores.companyhubapp.application.repositories.company.ClientAccountRepository;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccountSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientAccountCRUDService {
    private final ClientAccountRepository repository;

    @Autowired
    public ClientAccountCRUDService(ClientAccountRepository repository) {
        this.repository = repository;
    }

}
