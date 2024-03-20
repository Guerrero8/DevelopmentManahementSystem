package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.entity.Client;
import org.example.entity.Order;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Format;
import java.util.List;
import java.util.Optional;

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
    @SneakyThrows
    public String findOrderAddressOfMap(Integer orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            String address = order.getAddress();
            return "https://yandex.ru/maps/?text=" + URLEncoder.encode(address, StandardCharsets.UTF_8);
        } else {
            return null;
        }
    }
}
