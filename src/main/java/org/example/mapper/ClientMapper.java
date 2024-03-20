package org.example.mapper;

import org.example.controller.dto.SetupClientDTO;
import org.example.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper{
    Client toClientFromSetupClientDTO(SetupClientDTO setupClientDTO);
}
