package org.example.controller.dto;

import lombok.Data;

@Data
public class SetupClientDTO {
    private String clientFirstName;
    private String clientSurname;
    private String clientPatronymicName;
    private String customerCategory;
    private String phoneNumber;
    private String emailAddress;
}
