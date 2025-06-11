package br.unesp.mateusflores.companyhubapp.application.services.company;

import br.unesp.mateusflores.companyhubapp.application.mappers.ClientAccountMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.company.ClientAccountRepository;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccountSummaryDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientAccountCRUDService {
    private final ClientAccountRepository repository;
    private final ClientAccountMapper mapper;

    @Autowired
    public ClientAccountCRUDService(ClientAccountRepository repository, ClientAccountMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClientAccountSummaryDTO create(@Valid ClientAccountCreateRequestDTO dto) {
        var clientAccount = mapper.toClientAccount(dto);
        return mapper.toClientAccountSummaryDto(repository.save(clientAccount));
    }

    @GetMapping
    public Optional<ClientAccountSummaryDTO> findById(@NotNull UUID id) {
        return repository.findById(id)
                .map(mapper::toClientAccountSummaryDto);
    }

}
