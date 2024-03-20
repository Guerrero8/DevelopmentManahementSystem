package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.entity.Client;
import org.example.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServise {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public List<Order> getOrdersFromRepositoryByAddress(String desiredOrder) {
        return orderRepository.findOrderByAddressContaining(desiredOrder);
    }
    public List<Client> getClientsFromRepositoryBySurname(String disiredClient){
        return clientRepository.findByClientSurnameContaining(disiredClient);
    }
}
