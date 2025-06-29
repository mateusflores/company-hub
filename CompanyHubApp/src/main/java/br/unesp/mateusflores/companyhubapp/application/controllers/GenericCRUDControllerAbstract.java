package br.unesp.mateusflores.companyhubapp.application.controllers;

import br.unesp.mateusflores.companyhubapp.application.services.GenericCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class GenericCRUDControllerAbstract<Entity, ID extends Serializable, CreateDTO, UpdateDTO, ResponseDTO>
        implements GenericCRUDController<Entity, ID, CreateDTO, UpdateDTO, ResponseDTO> {

    protected final GenericCrudService<ID, CreateDTO, UpdateDTO, ResponseDTO> genericCrudService;

    public GenericCRUDControllerAbstract(GenericCrudService<ID, CreateDTO, UpdateDTO, ResponseDTO> genericCrudService) {
        this.genericCrudService = genericCrudService;
    }

    @Override
    public ResponseEntity<ResponseDTO> create(CreateDTO createDTO) {
        ResponseDTO responseDTO = genericCrudService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    public ResponseEntity<PagedModel<EntityModel<ResponseDTO>>> findAll(Pageable pageable,
                                                                        PagedResourcesAssembler<ResponseDTO> assembler) {
        Page<ResponseDTO> page = genericCrudService.findAll(pageable);
        return ResponseEntity.ok(assembler.toModel(page));
    }

    @Override
    public ResponseEntity<ResponseDTO> findById(ID id) {
        return genericCrudService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());    }

    @Override
    public ResponseEntity<ResponseDTO> update(ID id, UpdateDTO updateDTO) {
        ResponseDTO updatedDto = genericCrudService.update(id, updateDTO);
        return ResponseEntity.ok(updatedDto);    }

    @Override
    public ResponseEntity<Void> deleteById(ID id) {
        genericCrudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
