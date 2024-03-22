package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    @GeneratedValue
    @Column(name = "client_Id")
    private Integer clientId;
    @Column(name = "client_First_Name")
    private String clientFirstName;
    @Column(name = "client_Surname")
    private String clientSurname;
    @Column(name = "client_Patronymic_Name")
    private String clientPatronymicName; // отчество
    @Column(name = "customer_Category")
    private String customerCategory; // говорит о том кто клиент (физическое лицо, юридическое лицо, гос учереждение и тд)
    @Column(name = "phone_Number")
    private String phoneNumber; // номер телефона клиента
    @Column(name = "email_Address")
    private String emailAddress; // адрес электронной почты клиента
    @Column(name = "ClientInn")
    private String clientInn;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_fns_data_id", referencedColumnName = "client_fns_data_id")
    private ClientFns clientFns;
}
