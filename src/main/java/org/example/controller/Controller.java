package org.example.controller;

import org.example.service.SetupServise;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("api")
public class Controller {
    SetupServise setupServise;

    @PostMapping("/setupOrder")
    private void setupOrder(@RequestBody String clientSurname,
                            @RequestBody String orderStatus,
                            @RequestBody String address,
                            @RequestBody LocalDate dateOfContractConclusion,
                            @RequestBody LocalDateTime dateTimeOfInstallation,
                            @RequestBody LocalDate deadlineForServiceProvision,
                            @RequestBody float orderAmount ){
    setupServise.setupOrder(1,
            clientSurname,
            orderStatus,
            address,
            dateOfContractConclusion,
            dateTimeOfInstallation,
            deadlineForServiceProvision,
            orderAmount);
    }
}
