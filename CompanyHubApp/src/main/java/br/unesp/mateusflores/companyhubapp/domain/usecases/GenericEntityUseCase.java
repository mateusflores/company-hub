package br.unesp.mateusflores.companyhubapp.domain.usecases;

import br.unesp.mateusflores.companyhubapp.domain.repositories.GenericEntityRepository;

import java.util.Optional;
import java.util.UUID;

public class GenericEntityUseCase implements GenericEntityRepository<T, UUID> {

    private GenericEntityRepository genericEntityRepository;

    public GenericEntityUseCase(GenericEntityRepository genericEntityRepository) {
        this.genericEntityRepository = genericEntityRepository;
    }

    @Override
    public <S extends T> S save(S entity) {
        return genericEntityRepository.save(S);
    }

    @Override
    public Optional<T> findById(UUID id) {
        return genericEntityRepository.findById(UUID id)
    }

    @Override
    public Iterable<T> findAll() {
        return genericEntityRepository.findAll();
    }

    @Override
    public void delete(T entity) {
        genericEntityRepository.delete(T entity);
    }

    @Override
    public Long count(T entity) {
        return genericEntityRepository.count(T entity);
    }

    @Override
    public Boolean existsById(UUID id) {
        return genericEntityRepository.existsById(UUID id);
    }
}
