package org.example.controller.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SetupOrderDTO {
    private String orderStatus;
    private String address;
    private LocalDate dateOfContractConclusion;
    private LocalDate DeadlineForServiceProvision;
    private float orderAmount;
}
