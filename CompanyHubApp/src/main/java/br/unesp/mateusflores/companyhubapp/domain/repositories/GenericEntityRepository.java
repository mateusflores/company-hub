package br.unesp.mateusflores.companyhubapp.domain.repositories;

import java.util.Optional;

public interface GenericEntityRepository<T, UUID> {
    <S extends T> S save(S entity);

    Optional<T> findById(UUID id);

    Iterable<T> findAll();

    void delete(T entity);

    Long count(T entity);

    Boolean existsById(UUID id);
}
