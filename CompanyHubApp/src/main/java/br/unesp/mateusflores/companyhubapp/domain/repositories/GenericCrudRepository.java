package br.unesp.mateusflores.companyhubapp.domain.repositories;

import java.util.Optional;

public interface GenericCrudRepository<T, ID> {

    Optional<T> findById(ID id);

    Iterable<T> findAllById(Iterable<ID> ids);

    Iterable<T> findAll();

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    void deleteById(ID id);

    void deleteAllById(Iterable<? extends ID> ids);

    Long count();

}
