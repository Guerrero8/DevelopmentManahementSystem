package org.example.storage;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    @GeneratedValue
    private Integer clientId; // id клиента
    private String clientFirstName; // имя
    private String clientSurname; // фамилия
    private String clientPatronymicName; // отчество
    private String customerCategory; // говорит о том кто клиент (физическое лицо, юридическое лицо, гос учереждение и тд)
    private String phoneNumber; // номер телефона клиента
    private String emailAddress; // адрес электронной почты клиента

    @OneToMany
    private List<Order> orders;
}
