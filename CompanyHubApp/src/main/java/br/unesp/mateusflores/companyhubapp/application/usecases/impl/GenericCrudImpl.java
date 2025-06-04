package br.unesp.mateusflores.companyhubapp.application.usecases.impl;

import br.unesp.mateusflores.companyhubapp.application.usecases.interfaces.GenericCrudUseCase;
import br.unesp.mateusflores.companyhubapp.domain.annotation.UseCase;
import br.unesp.mateusflores.companyhubapp.domain.repositories.GenericEntityRepository;

import java.util.Optional;
import java.util.UUID;

@UseCase
public class GenericCrudImpl<T> implements GenericCrudUseCase<T> {
    private final GenericEntityRepository<T, UUID> repository;

    public GenericCrudImpl(GenericEntityRepository<T, UUID> repository) {
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
