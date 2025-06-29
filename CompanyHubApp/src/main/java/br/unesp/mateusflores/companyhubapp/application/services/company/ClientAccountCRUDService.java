package br.unesp.mateusflores.companyhubapp.application.services.company;

import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.mappers.ClientAccountMapper;
import br.unesp.mateusflores.companyhubapp.application.repositories.company.ClientAccountRepository;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.ClientAccountSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ClientAccountSummaryDTO create(ClientAccountCreateRequestDTO dto) {
        var clientAccount = mapper.createDtotoEntity(dto);
        return mapper.toClientAccountSummaryDto(repository.save(clientAccount));
    }

    @Transactional(readOnly = true)
    public Optional<ClientAccountSummaryDTO> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toClientAccountSummaryDto);
    }

    @Transactional
    public ClientAccountSummaryDTO update(ClientAccountUpdateRequestDTO dto) {
        var clientAccount = mapper.updateDtotoEntity(dto);
        return mapper.toClientAccountSummaryDto(repository.save(clientAccount));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public void deleteAllById(Iterable<UUID> ids) {
        repository.deleteAllById(ids);
    }

    public Boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
