package org.example.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class SetupClientDTO {
    private String clientFirstName;
    private String clientSurname;
    private String clientPatronymicName;
    private String customerCategory;
    private String phoneNumber;
    private String emailAddress;
    private String clientInn;
}
