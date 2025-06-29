package br.unesp.mateusflores.companyhubapp.application.mappers;

import org.mapstruct.MappingTarget;

public interface GenericMapper <Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    Entity createDtoToEntity(CreateDTO dto);

    Entity updateDtoToEntity(UpdateDTO dto);

    ResponseDTO entityToResponseDto(Entity entity);

    void updateEntityFromDto(UpdateDTO updateDTO, @MappingTarget Entity entity);
}
