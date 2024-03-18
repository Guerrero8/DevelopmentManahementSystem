package org.example.mapper;

import org.example.controller.dto.SetupOrderDTO;
import org.example.storage.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    Order toOrderFromOrderDTO(SetupOrderDTO setupOrderDTO);
}
