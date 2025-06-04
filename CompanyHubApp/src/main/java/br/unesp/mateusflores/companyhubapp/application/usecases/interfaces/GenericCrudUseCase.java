package br.unesp.mateusflores.companyhubapp.application.usecases.interfaces;

import java.util.Optional;
import java.util.UUID;

public interface GenericCrudUseCase<T> {

    <S extends T> S save(S entity);

    Optional<T> findById(UUID id);

    Iterable<T> findAll();

    void delete(T entity);

    Boolean existsById(UUID id);

}
