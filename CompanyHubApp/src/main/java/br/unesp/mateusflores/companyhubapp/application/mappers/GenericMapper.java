package br.unesp.mateusflores.companyhubapp.application.mappers;

public interface GenericMapper <Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    Entity createDtoToEntity(CreateDTO dto);

    Entity updateDtoToEntity(UpdateDTO dto);

    ResponseDTO entityToResponseDto(Entity entity);

}
