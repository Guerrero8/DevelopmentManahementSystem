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
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "address")
    private String address;
    @Column(name = "date_Of_contract_conclusion")
    private LocalDate dateOfContractConclusion;
    @Column(name = "date_time_of_installation")
    private LocalDateTime dateTimeOfInstallation;
    @Column(name = "deadline_forService_provision")
    private LocalDate DeadlineForServiceProvision;
    @Column(name = "order_amount")
    private float orderAmount;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
