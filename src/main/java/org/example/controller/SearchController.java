package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.SearchServise;
import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("serch")
public class SearchController {
    private final SearchServise searchServise;
    @PostMapping("/getOrderByAdderss")
    public Order getOrderByAddress(@RequestBody String desiredOrder){
        return searchServise.getOrderFromRepositoryByAddress(desiredOrder);
    }
    @PostMapping("/getClientBySurname")
    private Client getClientBySurname(@RequestBody String desiredClient){
        return searchServise.getClientFromRepositoryBySurname(desiredClient);
    }
}
