package br.unesp.mateusflores.companyhubapp.adapters.model.repositories;

import br.unesp.mateusflores.companyhubapp.domain.repositories.GenericEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GenericEntityService<T> implements GenericEntityRepository<T, UUID> {
    private final GenericEntityRepositoryJPA<T> repository;

    @Autowired
    public GenericEntityService(GenericEntityRepositoryJPA<T> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public Boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
