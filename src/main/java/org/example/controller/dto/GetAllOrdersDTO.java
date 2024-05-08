package org.example.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class GetAllOrdersDTO {
    private Integer Id;
    private String orderStatus;
    private String address;
    private LocalDate dateOfContractConclusion;
    private LocalDateTime dateTimeOfInstallation;
    private LocalDate deadlineForServiceProvision;
    private float OrderAmount;
}