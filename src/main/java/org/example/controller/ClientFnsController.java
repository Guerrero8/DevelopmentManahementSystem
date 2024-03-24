package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.ClientFns;
import org.example.service.ClientFsnService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ClientFnsController {
    private final ClientFsnService clientFsnService;
    @PostMapping("/getClientFnsByClientSurname")
    public ClientFns getClientFnsByClientSurname(@RequestParam String clientSurname){
        return clientFsnService.getClientFnsByClientSurname(clientSurname);
    }


}
