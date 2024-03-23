package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.ClientFns;
import org.example.controller.dto.SetupClientDTO;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientRepository;
import org.example.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final ClientFsnService clientFsnService;


    public void findClientFnsByClientId(Integer clientId){
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            if (!client.getClientInn().isEmpty()) {
                ClientFns clientFns = clientFsnService.getClientFnsData(client.getClientInn());
                clientFns.setClient(client);
            } else {
                throw  new RuntimeException("Клиент не имеет ИНН.");
            }
        } else {
            throw  new RuntimeException("Клиент не найден.");
        }
    }

    public List<Client> getClientsFromRepositoryBySurname(String disiredClient){
        return clientRepository.findByClientSurnameContaining(disiredClient);
    }
    public Client createClient(SetupClientDTO setupClientDTO) {
        Client client = clientMapper.toClientFromSetupClientDTO(setupClientDTO);
        clientRepository.save(client);
        return client;
    }
}