package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
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

    @PostMapping("/setupClient")
    private void setupClient(@RequestBody SetupClientDTO setupClientDTO) {
        clientService.createClient(setupClientDTO);
    }

    @PostMapping("/getClientBySurname")
    public List<Client> getClientBySurname(@RequestBody String desiredClient) {
        return clientService.getClientsFromRepositoryBySurname(desiredClient);
    }
    @PostMapping("/findClientFnsForClient")
    public void findClientFnsForClient(@RequestParam Integer clientId){
        clientService.findClientFnsByClientId(clientId);
    }
}
