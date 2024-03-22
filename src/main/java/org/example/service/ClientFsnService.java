package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.api.FnsClient;
import org.example.controller.dto.ClientFnsDTO;
import org.example.entity.ClientFns;
import org.example.repository.ClientFnsRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientFsnService {
    private final ObjectMapper objectMapper;
    private final ClientFnsRepository clientFnsRepository;
    private final FnsClient fnsClient;

    @SneakyThrows
    public ClientFns getClientFnsData(String req){
        if (clientFnsRepository.findClientFnsByInn(req) == null){
            String fnsData = fnsClient.getClientFnsData(req, "a7b7cf9f349a9ebca9d3a4cec8183bb11a664ff4");
            ClientFnsDTO clientFnsDTO = objectMapper.readValue(fnsData, ClientFnsDTO.class);
            ClientFns clientFns = setupClientFns(clientFnsDTO);
            clientFnsRepository.save(clientFns);
            return clientFns;
        } else {
            throw new RuntimeException("Клиент уже существует");
        }
    }

    public ClientFns setupClientFns(ClientFnsDTO clientFnsDTO){
        ClientFns clientFns = new ClientFns();
        clientFns.setInn(clientFnsDTO.getItems().get(0).getEntrepreneur().getInn());
        clientFns.setCitizenship(clientFnsDTO.getItems().get(0).getEntrepreneur().getCitizenship());

        clientFns.setOgrnip(clientFnsDTO.getItems().get(0).getEntrepreneur().getOgrnip());
        clientFns.setOgrnDate(clientFnsDTO.getItems().get(0).getEntrepreneur().getOgrnDate());

        clientFns.setType(clientFnsDTO.getItems().get(0).getEntrepreneur().getType());
        clientFns.setRegistration(clientFnsDTO.getItems().get(0).getEntrepreneur().getTaxAuthority().getRegistration());
        clientFns.setRegDate(clientFnsDTO.getItems().get(0).getEntrepreneur().getTaxAuthority().getRegDate());
        clientFns.setAccounting(clientFnsDTO.getItems().get(0).getEntrepreneur().getTaxAuthority().getAccounting());

        clientFns.setOkfs(clientFnsDTO.getItems().get(0).getEntrepreneur().getStatusCodes().getOkfs());
        clientFns.setOktmo(clientFnsDTO.getItems().get(0).getEntrepreneur().getStatusCodes().getOktmo());
        clientFns.setOkpo(clientFnsDTO.getItems().get(0).getEntrepreneur().getStatusCodes().getOkpo());
        clientFns.setOkogu(clientFnsDTO.getItems().get(0).getEntrepreneur().getStatusCodes().getOkogu());
        return clientFns;
    }
}
