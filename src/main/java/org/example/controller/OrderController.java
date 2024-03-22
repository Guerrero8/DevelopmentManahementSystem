package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupOrderDTO;
import org.example.entity.Order;
import org.example.service.OrderServise;
import org.example.service.ClientServise;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class OrderController {
    private final OrderServise orderServise;

    @PostMapping("/setupOrder")
    private void setupOrder(@RequestBody SetupOrderDTO setupOrderDTO) {
        orderServise.setupOrder(setupOrderDTO);
    }
    @PostMapping("/getOrderByAdderss")
    public List<Order> getOrderByAddress(@RequestBody String desiredOrder){
        return orderServise.getOrdersFromRepositoryByAddress(desiredOrder);
    }
    @PostMapping("/findOrderAddressOfMap")
    public String findOrderAddressOfMap(@RequestParam Integer orderId){
        return orderServise.findOrderAddressOfMap(orderId);
    }
}
