package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.CreateOrderDTO;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        log.info("request to create order: {}", createOrderDTO);
        orderService.createOrder(createOrderDTO);
    }
    @PostMapping("/getOrderByAdders")
    public List<Order> getOrderByAddress(@RequestParam String orderAddress){
        return orderService.getOrdersFromRepositoryByAddress(orderAddress);
    }
    @PostMapping("/getOrderById")
    public Order getOrderById(@RequestParam Integer orderId){
        return  orderService.getOrderById(orderId);
    }
    @DeleteMapping("/deleteOrderById")
    public void deleteOrderById(@RequestParam Integer orderId){
        orderService.deleteOrderById(orderId);
    }
    @PostMapping("/findOrderAddressOfMap")
    public String findOrderAddressOfMap(@RequestParam Integer orderId){
        return orderService.findOrderAddressOfMap(orderId);
    }
    @PostMapping("/updateOrder")
    public void updateOrder(){

    }
}
