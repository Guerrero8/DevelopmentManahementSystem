package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
import org.example.controller.dto.SetupOrderDTO;
import org.example.mapper.ClientMapper;
import org.example.mapper.OrderMapper;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.entity.Client;
import org.example.entity.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SetupServise {
    private final ClientMapper clientMapper;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public Client setupClient(SetupClientDTO setupClientDTO) {
        Client client = clientMapper.toClientFromSetupClientDTO(setupClientDTO);
        clientRepository.save(client);
        return client;
    }

    public Order setupOrder(SetupOrderDTO setupOrderDTO) {
        Optional<Client> client = clientRepository.findById(setupOrderDTO.getClientId());
        Order order = orderMapper.toOrderFromSetupOrderDTO(setupOrderDTO);
        order.setClient(client.get());
        orderRepository.save(order);
        return order;
    }
}