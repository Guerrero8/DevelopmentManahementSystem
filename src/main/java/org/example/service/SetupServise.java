package org.example.service;

import org.example.storage.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SetupServise {
    public Order setupOrder(Integer orderId,
                            String clientSurname,
                            String orderStatus,
                            String address,
                            LocalDate dateOfContractConclusion,
                            LocalDateTime dateTimeOfInstallation,
                            LocalDate deadlineForServiceProvision,
                            float orderAmount) {
         Order order = new Order(orderId,
                 clientSurname,
                 orderStatus,
                 address,
                 dateOfContractConclusion,
                 dateTimeOfInstallation,
                 deadlineForServiceProvision,
                 orderAmount);
         return order;
    }
}
