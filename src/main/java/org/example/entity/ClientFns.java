package org.example.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client_fns")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientFns {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer Id;
    private String inn;
    private String ogrnip;
    private String ogrnDate;
    private String regDate;

    @OneToOne(mappedBy = "clientFns", fetch = FetchType.LAZY)
    private Client client;
}

