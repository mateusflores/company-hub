package br.unesp.mateusflores.companyhubapp.application.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericCrudService <ID, CreateDTO, UpdateDTO, ResponseDTO> {

    Optional<ResponseDTO> findById(ID id);

    Page<ResponseDTO> findAll(Pageable pageable);

    ResponseDTO create(CreateDTO dto);

    ResponseDTO update(ID id, UpdateDTO dto);

    void deleteById(ID id);

    void deleteAllById(Iterable<ID> ids);

    boolean existsById(ID id);

}
