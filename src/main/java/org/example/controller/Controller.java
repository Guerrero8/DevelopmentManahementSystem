package org.example.controller;

import org.example.service.SetupServise;
import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("api")
public class Controller {
    SetupServise setupServise;

    @PostMapping("/setupOrder")
    private Order setupOrder(@RequestBody String clientSurname,
                             @RequestBody String orderStatus,
                             @RequestBody String address,
                             @RequestBody LocalDate dateOfContractConclusion,
                             @RequestBody LocalDateTime dateTimeOfInstallation,
                             @RequestBody LocalDate deadlineForServiceProvision,
                             @RequestBody float orderAmount){
       return setupServise.setupOrder(clientSurname,
            orderStatus,
            address,
            dateOfContractConclusion,
            dateTimeOfInstallation,
            deadlineForServiceProvision,
            orderAmount);
    }
    @PostMapping("/setupClient")
    private Client setupClient(@RequestBody String clientFirstName,
                               @RequestBody String clientSurname,
                               @RequestBody String clientPatronymicName,
                               @RequestBody String customerCategory,
                               @RequestBody String phoneNumber,
                               @RequestBody String emailAddress){
        return setupServise.setupClient(clientFirstName,
                clientSurname,
                clientPatronymicName,
                customerCategory,
                phoneNumber,
                emailAddress);
    }
}
