package org.example.entity;

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
    @Column(name = "order_Id")
    private Integer orderId; // id заказа
    @Column(name = "order_Status")
    private String orderStatus; // статус выполнения заказа
    @Column(name = "address")
    private String address; // адрес проведения работ
    @Column(name = "date_Of_Contract_Conclusion")
    private LocalDate dateOfContractConclusion; // дата заключения договора
    @Column(name = "date_Time_Of_Installation")
    private LocalDateTime dateTimeOfInstallation; // назначенная дата выполнения заказа
    @Column(name = "Deadline_ForService_Provision")
    private LocalDate DeadlineForServiceProvision; // крайний срок выполнения заказа
    @Column(name = "order_Amount")
    private float orderAmount; // цена работ

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private Client client;
}
