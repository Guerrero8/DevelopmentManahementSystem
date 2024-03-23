package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupOrderDTO;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/setupOrder")
    private void setupOrder(@RequestBody SetupOrderDTO setupOrderDTO) {
        orderService.setupOrder(setupOrderDTO);
    }
    @PostMapping("/getOrderByAdderss")
    public List<Order> getOrderByAddress(@RequestBody String desiredOrder){
        return orderService.getOrdersFromRepositoryByAddress(desiredOrder);
    }
    @PostMapping("/findOrderAddressOfMap")
    public String findOrderAddressOfMap(@RequestParam Integer orderId){
        return orderService.findOrderAddressOfMap(orderId);
    }
}
