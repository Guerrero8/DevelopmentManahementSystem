package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.controller.dto.SetupOrderDTO;
import org.example.mapper.OrderMapper;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.entity.Client;
import org.example.entity.Order;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServise {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderMapper orderMapper;

    public List<Order> getOrdersFromRepositoryByAddress(String desiredOrder) {
        return orderRepository.findOrderByAddressContaining(desiredOrder);
    }
    public Order setupOrder(SetupOrderDTO setupOrderDTO) {
        Optional<Client> client = clientRepository.findById(setupOrderDTO.getClientId());
        Order order = orderMapper.toOrderFromSetupOrderDTO(setupOrderDTO);
//        order.setClient(client.get());
        orderRepository.save(order);
        return order;
    }
    @SneakyThrows
    public String findOrderAddressOfMap(Integer orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return "https://yandex.ru/maps/?text=" + URLEncoder.encode(order.getAddress(), StandardCharsets.UTF_8);
        } else {
            throw new RuntimeException("Адрес не найден");
        }
    }
}
