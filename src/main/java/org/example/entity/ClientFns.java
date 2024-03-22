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
    @Column(name = "inn")
    private String inn;
    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "ogrnip")
    private String ogrnip;
    @Column(name = "ogrn_date")
    private String ogrnDate;

    @Column(name = "type")
    private String type;
    @Column(name = "reg")
    private String registration;
    @Column(name = "reg_date")
    private String regDate;
    @Column(name = "accounting")
    private String accounting;

    @Column(name = "okpo")
    private String okpo;
    @Column(name = "oktmo")
    private String oktmo;
    @Column(name = "okfs")
    private String okfs;
    @Column(name = "okogu")
    private String okogu;


    @OneToOne(mappedBy = "clientFns", fetch = FetchType.LAZY)
    private Client client;
}

