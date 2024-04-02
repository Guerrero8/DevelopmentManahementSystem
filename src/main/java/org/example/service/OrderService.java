package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.controller.dto.CreateOrderDTO;
import org.example.controller.dto.UpdateOrderDTO;
import org.example.mapper.OrderMapper;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.entity.Client;
import org.example.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderMapper orderMapper;


    public Order createOrder(CreateOrderDTO createOrderDTO) {
        Optional<Client> client = clientRepository.findById(createOrderDTO.getClientId());
        Order order = orderMapper.toOrderFromSetupOrderDTO(createOrderDTO);
        order.setClient(client.get());
        orderRepository.save(order);
        return order;
    }
    public List<Order> getOrdersFromRepositoryByAddress(String orderAddress) {
        return orderRepository.findOrderByAddressContaining(orderAddress);
    }
    public Order getOrderById(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()){
            return optionalOrder.get();
        } else {
            throw new RuntimeException("Заказа не существует");
        }
    }
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);
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
    public Order updateOrder(UpdateOrderDTO updateOrderDTO){
        Optional<Order> optionalOrder = orderRepository.findById(updateOrderDTO.getOrderId());
        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setOrderStatus(updateOrderDTO.getOrderStatus());
            order.setAddress(updateOrderDTO.getAddress());
            order.setDateOfContractConclusion(updateOrderDTO.getDateOfContractConclusion());
            order.setDateTimeOfInstallation(updateOrderDTO.getDateTimeOfInstallation());
            order.setDeadlineForServiceProvision(updateOrderDTO.getDeadlineForServiceProvision());
            order.setOrderAmount(updateOrderDTO.getOrderAmount());
            return order;
        } else {
            throw new RuntimeException("Заказ не найден");
        }
    }
}
