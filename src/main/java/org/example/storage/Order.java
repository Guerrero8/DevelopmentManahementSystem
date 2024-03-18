package org.example.storage;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "orders")
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId; // id заказа
    private String orderStatus; // статус выполнения заказа
    private String address; // адрес проведения работ (структура -> город, улица, дом, подъезд если есть, квартира если есть)
    private LocalDate dateOfContractConclusion; // дата заключения договора
    private LocalDateTime dateTimeOfInstallation; // назначенная дата выполнения заказа
    private LocalDate DeadlineForServiceProvision; // крайний срок выполнения заказа
    private float orderAmount; // цена работ

    @ManyToOne
    private Client client;
}
