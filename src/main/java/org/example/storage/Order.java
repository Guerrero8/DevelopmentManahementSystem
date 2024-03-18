package org.example.storage;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    {
        //todo сделать сортировку по дедлайну и статусу заказа(фраза "заказ нуждается в срочном выполнении либо в продлении срока действия договора")
    }
    @Id
    @GeneratedValue
    private Integer orderId; // id заказа
    private String clientSurname; // Фамилия клиента сделавшего этот заказ
    private String orderStatus; // статус выполнения заказа
    private String address; // адрес проведения работ (структура -> город, улица, дом, подъезд если есть, квартира если есть)
    private LocalDate dateOfContractConclusion; // дата заключения договора
    private LocalDateTime dateTimeOfInstallation; // назначенная дата выполнения заказа
    private LocalDate DeadlineForServiceProvision; // крайний срок выполнения заказа
    private float orderAmount; // цена работ
}
