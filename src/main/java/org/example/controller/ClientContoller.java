package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.CreateClientDTO;
import org.example.entity.Client;
import org.example.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ClientContoller {
    private final ClientService clientService;

    @PostMapping("/createClient")
    private void createClient(@RequestBody CreateClientDTO createClientDTO) {
        clientService.createClient(createClientDTO);
    }

    @PostMapping("/getClientBySurname")
    public List<Client> getClientBySurname(@RequestParam String clientSurname) {
        return clientService.getClientsFromRepositoryBySurname(clientSurname);
    }
    @PostMapping("/getClientById")
    public Client getClientById(@RequestParam Integer id) {
        return clientService.getClientFromRepositoryById(id);
    }
    @PostMapping("/createClientFnsForClient")
    public void createClientFnsForClient(@RequestParam Integer clientId){
        clientService.CreateClientFnsByClientId(clientId);
    }

}
