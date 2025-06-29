package br.unesp.mateusflores.companyhubapp.application.services;

import br.unesp.mateusflores.companyhubapp.application.mappers.GenericMapper;
import br.unesp.mateusflores.companyhubapp.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericCrudServiceImpl <Entity, ID, CreateDTO, UpdateDTO, ResponseDTO>
implements GenericCrudService<ID, CreateDTO, UpdateDTO, ResponseDTO> {

    protected final JpaRepository<Entity, ID> repository;
    protected final GenericMapper<Entity, CreateDTO, UpdateDTO, ResponseDTO> mapper;

    public GenericCrudServiceImpl(JpaRepository<Entity, ID> repository,
                                  GenericMapper<Entity, CreateDTO, UpdateDTO, ResponseDTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ResponseDTO> findById(ID id) {
        return repository.findById(id).map(mapper::entityToResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResponseDTO> findAll(Pageable pageable) {
        Page<Entity> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToResponseDto);
    }

    @Override
    @Transactional
    public ResponseDTO create(CreateDTO dto) {
        Entity entity = mapper.createDtoToEntity(dto);
        return mapper.entityToResponseDto(repository.save(entity));
    }

    @Override
    @Transactional
    public ResponseDTO update(ID id, UpdateDTO dto) {
        Entity entityToUpdate = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso com ID " + id + " não encontrado."));
        Entity updatedEntity = repository.save(mapper.updateDtoToEntity(dto));
        return mapper.entityToResponseDto(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllById(Iterable<ID> ids) {
        List<ID> notFoundIds = new ArrayList<>();

        for (ID id : ids) {
            if (!repository.existsById(id)) {
                notFoundIds.add(id);
            }
        }

        if (!notFoundIds.isEmpty()) {
            throw new ResourceNotFoundException("Os seguintes IDs não foram encontrados: " + notFoundIds.toString());
        }

        repository.deleteAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
