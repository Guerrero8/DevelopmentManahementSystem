package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.SetupClientDTO;
import org.example.entity.Client;
import org.example.service.SearchServise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ClientContoller {
    private final SearchServise searchServise;
    private final ClientContoller setupServise;

    @PostMapping("/setupClient")
    private void setupClient(@RequestBody SetupClientDTO setupClientDTO) {
        setupServise.setupClient(setupClientDTO);
    }

    @PostMapping("/getClientBySurname")
    public List<Client> getClientBySurname(@RequestBody String desiredClient) {
        return searchServise.getClientsFromRepositoryBySurname(desiredClient);
    }
}
