package org.example.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.GetAllClientDTO;
import org.example.controller.dto.GetAllClientInfoDTO;
import org.example.controller.dto.UpdateClientDTO;
import org.example.entity.ClientFns;
import org.example.controller.dto.CreateClientDTO;
import org.example.entity.Order;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientFnsRepository;
import org.example.repository.ClientRepository;
import org.example.entity.Client;
import org.example.repository.OrderRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final ClientFsnService clientFsnService;
    private final ClientFnsRepository clientFnsRepository;
    private final OrderRepository orderRepository;

    public void createClient(CreateClientDTO createClientDTO) {
        Client client = clientMapper.toClientFromSetupClientDTO(createClientDTO);
        clientRepository.save(client);
    }

    public List<GetAllClientDTO> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<GetAllClientDTO> getAllClientDTOS = new ArrayList<>();
        for (Client client : clients) {
            GetAllClientDTO getAllClientDTO = new GetAllClientDTO();
            getAllClientDTO.setId(client.getId());
            getAllClientDTO.setClientFirstName(client.getClientFirstName());
            getAllClientDTO.setClientSurname(client.getClientSurname());
            getAllClientDTO.setClientPatronymicName(client.getClientPatronymicName());
            getAllClientDTO.setCustomerCategory(client.getCustomerCategory());
            getAllClientDTO.setPhoneNumber(client.getPhoneNumber());
            getAllClientDTO.setEmailAddress(client.getEmailAddress());
            getAllClientDTO.setClientInn(client.getClientInn());
            getAllClientDTOS.add(getAllClientDTO);
        }
        return getAllClientDTOS;
    }

    public Client getClientFromRepositoryById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new RuntimeException("Клиент не найден");
        }
    }

    @Transactional
    public void deleteClientAndHisFnsByClientId(Integer id) {
        clientRepository.delete(getClientFromRepositoryById(id));
    }

    public void createClientFnsByClientId(Integer clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            String clientInn = client.getClientInn();
            if (!clientInn.isEmpty()) {
                ClientFns clientFns = clientFsnService.createClientFnsData(clientInn);
                clientFns.setClient(client);
                clientFnsRepository.save(clientFns);
            } else {
                throw new RuntimeException("Клиент не имеет ИНН.");
            }
        } else {
            throw new RuntimeException("Клиент не найден.");
        }
    }

    public Client updateClientById(UpdateClientDTO updateClientDTO) {
        Optional<Client> optionalClient = clientRepository.findById(updateClientDTO.getClientId());
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setClientFirstName(updateClientDTO.getClientFirstName());
            client.setClientSurname(updateClientDTO.getClientSurname());
            client.setClientPatronymicName(updateClientDTO.getClientPatronymicName());
            client.setCustomerCategory(updateClientDTO.getCustomerCategory());
            client.setPhoneNumber(updateClientDTO.getPhoneNumber());
            client.setEmailAddress(updateClientDTO.getEmailAddress());
            client.setClientInn(updateClientDTO.getClientInn());
            return client;
        } else {
            throw new RuntimeException("Клиента с таким ID не существует.");
        }
    }

    public GetAllClientInfoDTO getAllClietnInfo(Integer clientId) {
        GetAllClientInfoDTO getAllClientInfoDTO = new GetAllClientInfoDTO();
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {

            Client client = optionalClient.get();
            getAllClientInfoDTO.setClients(List.of(GetAllClientInfoDTO.ClientInfoDTO.builder()
                    .clientSurname(client.getClientSurname())
                    .clientFirstName(client.getClientFirstName())
                    .clientPatronymicName(client.getClientPatronymicName())
                    .customerCategory(client.getCustomerCategory())
                    .phoneNumber(client.getPhoneNumber())
                    .emailAddress(client.getEmailAddress())
                    .clientInn(client.getClientInn())
                    .build()
            ));


            Optional<ClientFns> optionalClientFns = clientFnsRepository.findClientFnsByClient(client);
            if (optionalClientFns.isPresent()) {
                ClientFns clientFns = optionalClientFns.get();
                getAllClientInfoDTO.setClientFnsList(List.of(GetAllClientInfoDTO.ClientFnsInfoDTO.builder()
                        .inn(clientFns.getInn())
                        .citizenship(clientFns.getCitizenship())
                        .ogrnip(clientFns.getOgrnip())
                        .ogrnDate(clientFns.getOgrnDate())
                        .regDate(clientFns.getRegDate())
                        .accounting(clientFns.getAccounting())
                        .okpo(clientFns.getOkpo())
                        .oktmo(clientFns.getOktmo())
                        .okfs(clientFns.getOkfs())
                        .okogu(clientFns.getOkogu())
                        .build()
                ));
            }

            List<Order> orders = orderRepository.findOrdersByClient(client);
            getAllClientInfoDTO.setOrders(orders.stream().map(order -> GetAllClientInfoDTO.OrderInfoDTO.builder()
                    .orderStatus(order.getOrderStatus())
                    .address(order.getAddress())
                    .dateOfContractConclusion(order.getDateOfContractConclusion())
                    .dateTimeOfInstallation(order.getDateTimeOfInstallation())
                    .deadlineForServiceProvision(order.getDeadlineForServiceProvision())
                    .OrderAmount(order.getOrderAmount())
                    .build())
                    .collect(Collectors.toList()
                    ));

            return getAllClientInfoDTO;
        } else {
            throw new RuntimeException("Клиента с таким id не существует");
        }
    }
}