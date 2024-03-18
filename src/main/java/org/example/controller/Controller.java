package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
import org.example.controller.dto.SetupOrderDTO;
import org.example.service.SetupServise;
import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class Controller {
    private final SetupServise setupServise;

    @PostMapping("/setupOrder")
    private Order setupOrder(@RequestBody SetupOrderDTO setupOrderDTO) {
        return setupServise.setupOrder(setupOrderDTO);
    }

    @PostMapping("/setupClient")
    private Client setupClient(@RequestBody SetupClientDTO setupClientDTO) {
        return setupServise.setupClient(setupClientDTO);
    }
}