package org.example.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateOrderDTO {
    private Integer orderId;
    private String orderStatus;
    private String address;
    private LocalDate dateOfContractConclusion;
    private LocalDateTime dateTimeOfInstallation;
    private LocalDate DeadlineForServiceProvision;
    private float OrderAmount;

    private Integer clientId;
}

