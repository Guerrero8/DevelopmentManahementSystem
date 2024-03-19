package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchServise {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public Order getOrderFromRepositoryByAddress(String desiredOrder) {
        return orderRepository.findOrderByAddressContaining(desiredOrder);
    }
    public Client getClientFromRepositoryBySurname(String disiredClient){
        return clientRepository.findByClientSurnameContaining(disiredClient);
    }
}
