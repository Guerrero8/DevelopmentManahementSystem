package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
import org.example.entity.Client;
import org.example.service.OrderServise;
import org.example.service.ClientServise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ClientContoller {
    private final ClientServise clientServise;

    @PostMapping("/setupClient")
    private void setupClient(@RequestBody SetupClientDTO setupClientDTO) {
        clientServise.setupClient(setupClientDTO);
    }

    @PostMapping("/getClientBySurname")
    public List<Client> getClientBySurname(@RequestBody String desiredClient) {
        return clientServise.getClientsFromRepositoryBySurname(desiredClient);
    }
}
