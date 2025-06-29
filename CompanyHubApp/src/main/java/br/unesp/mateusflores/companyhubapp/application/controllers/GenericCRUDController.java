package br.unesp.mateusflores.companyhubapp.application.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface GenericCRUDController<Entity, ID extends Serializable, CreateDTO, UpdateDTO, ResponseDTO> {

    ResponseEntity<ResponseDTO> create(CreateDTO createDTO);

    ResponseEntity<PagedModel<EntityModel<ResponseDTO>>> findAll(Pageable pageable,
                                                                 PagedResourcesAssembler<ResponseDTO> assembler);

    ResponseEntity<ResponseDTO> findById(ID id);

    ResponseEntity<ResponseDTO> update(ID id, UpdateDTO updateDTO);

    ResponseEntity<Void> deleteById(ID id);

}
