package org.example.service;

import org.example.storage.Client;
import org.example.storage.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SetupServise {
    public Order setupOrder(String clientSurname,
                            String orderStatus,
                            String address,
                            LocalDate dateOfContractConclusion,
                            LocalDateTime dateTimeOfInstallation,
                            LocalDate deadlineForServiceProvision,
                            float orderAmount) {
        Order order = new Order(1,
                clientSurname,
                orderStatus,
                address,
                dateOfContractConclusion,
                dateTimeOfInstallation,
                deadlineForServiceProvision,
                orderAmount);
        return order;
    }

    public Client setupClient(String clientFirstName,
                             String clientSurname,
                             String clientPatronymicName,
                             String customerCategory,
                             String phoneNumber,
                             String emailAddress){
        Client client = new Client(1,
                clientFirstName,
                clientSurname,
                clientPatronymicName,
                customerCategory,
                phoneNumber,
                emailAddress);
        return client;

    }
}
