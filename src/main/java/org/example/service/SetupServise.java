package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
import org.example.controller.dto.SetupOrderDTO;
import org.example.mapper.ClientMapper;
import org.example.mapper.OrderMapper;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetupServise {
    private final ClientMapper clientMapper;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    public Order setupOrder(SetupOrderDTO setupOrderDTO) {
        Order order = orderMapper.toOrderFromSetupOrderDTO(setupOrderDTO);
        orderRepository.save(order);
        return order;
    }
    public Client setupClient(SetupClientDTO setupClientDTO){
        Client client = clientMapper.toClientFromSetupClientDTO(setupClientDTO);
        clientRepository.save(client);
        return client;
    }
}
