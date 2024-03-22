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
    private Integer orderId;
    @Column(name = "order_Status")
    private String orderStatus;
    @Column(name = "address")
    private String address;
    @Column(name = "date_Of_Contract_Conclusion")
    private LocalDate dateOfContractConclusion;
    @Column(name = "date_Time_Of_Installation")
    private LocalDateTime dateTimeOfInstallation;
    @Column(name = "Deadline_ForService_Provision")
    private LocalDate DeadlineForServiceProvision;
    @Column(name = "order_Amount")
    private float orderAmount;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
