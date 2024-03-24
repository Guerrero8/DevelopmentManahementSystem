package org.example.mapper;

import org.example.controller.dto.CreateOrderDTO;
import org.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(target = "dateTimeOfInstallation", source = "dateTimeOfInstallation")
    @Mapping(target = "client", ignore = true)
    Order toOrderFromSetupOrderDTO(CreateOrderDTO createOrderDTO);

}
