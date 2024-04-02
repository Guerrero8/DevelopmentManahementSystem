package org.example.controller.dto;

import lombok.Data;

@Data
public class UpdateClientDTO {
    private Integer clientId;
    private String clientFirstName;
    private String clientSurname;
    private String clientPatronymicName;
    private String customerCategory;
    private String phoneNumber;
    private String emailAddress;
    private String clientInn;
}

