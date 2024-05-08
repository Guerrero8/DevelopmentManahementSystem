package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.CreateClientDTO;
import org.example.controller.dto.GetAllClientDTO;
import org.example.controller.dto.GetAllOrdersDTO;
import org.example.controller.dto.UpdateClientDTO;
import org.example.entity.Client;
import org.example.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api")
public class ClientContoller {
    private final ClientService clientService;

    @GetMapping("/getAllClients")
    private List<GetAllClientDTO> createClient() {
        log.info("getAllClients: {}", clientService.findAllClients());
        return clientService.findAllClients();
    }

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
    @DeleteMapping("/deleteClientById")
    public void deleteClientAndHisFnsByClientId(@RequestParam Integer id) {
        clientService.deleteClientAndHisFnsByClientId(id);
    }
    @PostMapping("/createClientFnsForClient")
    public void createClientFnsForClient(@RequestParam Integer clientId){
        clientService.createClientFnsByClientId(clientId);
    }
    @PostMapping("/updateClientById")
    public void updateClientById(@RequestBody UpdateClientDTO updateClientDTO){
        clientService.updateClientById(updateClientDTO);
    }
}
