package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
import org.example.controller.dto.SetupOrderDTO;
import org.example.mapper.ClientMapper;
import org.example.mapper.OrderMapper;
import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetupServise {
    private final ClientMapper clientMapper;
    private final OrderMapper orderMapper;
    public Order setupOrder(SetupOrderDTO setupOrderDTO) {
        return orderMapper.toOrderFromOrderDTO(setupOrderDTO);
    }
    public Client setupClient(SetupClientDTO setupClientDTO){
        return clientMapper.toClientFromSetupClientDTO(setupClientDTO);
    }
}
