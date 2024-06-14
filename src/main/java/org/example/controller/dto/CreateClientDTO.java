package org.example.controller.dto;

import lombok.Data;

@Data
public class CreateClientDTO {
    private String clientFirstName;
    private String clientSurname;
    private String clientPatronymicName;
    private String phoneNumber;
    private String emailAddress;
    private String clientInn;
}
