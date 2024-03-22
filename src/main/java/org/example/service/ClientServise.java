package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.ClientFns;
import org.example.controller.dto.SetupClientDTO;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientRepository;
import org.example.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServise {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final ClientFsnService clientFsnService;

    public List<Client> getClientsFromRepositoryBySurname(String disiredClient){
        return clientRepository.findByClientSurnameContaining(disiredClient);
    }
    public Client setupClient(SetupClientDTO setupClientDTO) {
        Client client = clientMapper.toClientFromSetupClientDTO(setupClientDTO);
        ClientFns clientFns = clientFsnService.getClientFnsData(setupClientDTO.getClientInn());
        clientFns.setClient(client);
        clientRepository.save(client);
        return client;
    }
}