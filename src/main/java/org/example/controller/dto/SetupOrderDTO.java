package org.example.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SetupOrderDTO {
    private String orderStatus;
    private String address;
    private LocalDate dateOfContractConclusion;
    private LocalDateTime dateTimeOfInstallation; //todo почему то в бд это поле null что бы я не делал
    private LocalDate DeadlineForServiceProvision;
    private float orderAmount;
}
