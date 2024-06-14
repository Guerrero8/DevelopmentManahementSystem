package org.example.controller.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetAllClientDTO {
    private Integer Id;
    private String clientFirstName;
    private String clientSurname;
    private String clientPatronymicName;
    private String phoneNumber;
    private String emailAddress;
    private String clientInn;
}
