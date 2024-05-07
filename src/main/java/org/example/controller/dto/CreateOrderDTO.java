package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CreateOrderDTO {
    private String orderStatus;
    private String address;
    private LocalDate dateOfContractConclusion;
    private LocalDateTime dateTimeOfInstallation;
    private LocalDate deadlineForServiceProvision;
    private float OrderAmount;

    private Integer clientId;
}
