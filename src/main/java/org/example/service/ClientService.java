package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.ClientFns;
import org.example.controller.dto.CreateClientDTO;
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
    
    public void createClient(CreateClientDTO createClientDTO) {
        Client client = clientMapper.toClientFromSetupClientDTO(createClientDTO);
        clientRepository.save(client);
    }
    public List<Client> getClientsFromRepositoryBySurname(String clientSurname){
        return clientRepository.findByClientSurnameContaining(clientSurname);
    }
    public Client getClientFromRepositoryById(Integer id){
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()){
           return  client.get();
        } else {
            throw new RuntimeException("Клиент не найден");
        }
    }
    public void CreateClientFnsByClientId(Integer clientId){
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            String clientInn = client.getClientInn();
            if (!clientInn.isEmpty()) {
                ClientFns clientFns = clientFsnService.getClientFnsData(clientInn);
                clientFns.setClient(client);
            } else {
                throw  new RuntimeException("Клиент не имеет ИНН.");
            }
        } else {
            throw  new RuntimeException("Клиент не найден.");
        }
    }
}