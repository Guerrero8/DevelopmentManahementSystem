package org.example.entity;

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
    @Column(name = "client_Id")
    private Integer clientId; // id клиента
    @Column(name = "client_First_Name")
    private String clientFirstName; // имя
    @Column(name = "client_Surname")
    private String clientSurname; // фамилия
    @Column(name = "client_Patronymic_Name")
    private String clientPatronymicName; // отчество
    @Column(name = "customer_Category")
    private String customerCategory; // говорит о том кто клиент (физическое лицо, юридическое лицо, гос учереждение и тд)
    @Column(name = "phone_Number")
    private String phoneNumber; // номер телефона клиента
    @Column(name = "email_Address")
    private String emailAddress; // адрес электронной почты клиента

    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}
