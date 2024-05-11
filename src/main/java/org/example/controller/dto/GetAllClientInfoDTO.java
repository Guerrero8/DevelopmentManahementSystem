package org.example.controller.dto;

import lombok.*;
import org.example.entity.Client;
import org.example.entity.ClientFns;
import org.example.entity.Order;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetAllClientInfoDTO{
    private List<ClientInfoDTO> clients;
    private List<ClientFnsInfoDTO> clientFnsList;
    private List<OrderInfoDTO> orders;
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class ClientInfoDTO {
        private String clientFirstName;
        private String clientSurname;
        private String clientPatronymicName;
        private String customerCategory;
        private String phoneNumber;
        private String emailAddress;
        private String clientInn;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class ClientFnsInfoDTO {
        private String inn;
        private String citizenship;
        private String ogrnip;
        private String ogrnDate;
        private String type;
        private String registration;
        private String regDate;
        private String accounting;
        private String okpo;
        private String oktmo;
        private String okfs;
        private String okogu;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class OrderInfoDTO {
        private String orderStatus;
        private String address;
        private LocalDate dateOfContractConclusion;
        private LocalDateTime dateTimeOfInstallation;
        private LocalDate deadlineForServiceProvision;
        private float OrderAmount;
    }
}