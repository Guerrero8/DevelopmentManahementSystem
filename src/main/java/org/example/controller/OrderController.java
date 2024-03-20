package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupOrderDTO;
import org.example.entity.Order;
import org.example.service.SearchServise;
import org.example.service.SetupServise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class OrderController {
    private final SetupServise setupServise;
    private final SearchServise searchServise;

    @PostMapping("/setupOrder")
    private void setupOrder(@RequestBody SetupOrderDTO setupOrderDTO) {
        setupServise.setupOrder(setupOrderDTO);
    }
    @PostMapping("/getOrderByAdderss")
    public List<Order> getOrderByAddress(@RequestBody String desiredOrder){
        return searchServise.getOrdersFromRepositoryByAddress(desiredOrder);
    }
    @PostMapping("/findOrderAddressOfMap")
    public String findOrderAddressOfMap(@RequestParam Integer orderId){
        return searchServise.findOrderAddressOfMap(orderId);
    }
}
