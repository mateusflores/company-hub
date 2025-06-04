package br.unesp.mateusflores.companyhubapp.adapters.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenericEntityRepositoryJPA<T> extends CrudRepository<T, UUID> {

}
