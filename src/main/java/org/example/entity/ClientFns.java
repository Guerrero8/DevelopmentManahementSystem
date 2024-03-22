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
    @Column(name = "client_fns_data_id")
    private Integer clientFbsDataId;
    private String fullName;
    private String inn;
    private String ogrnip;
    private String ogrnDate;
    private String regDate;

    /*@OneToOne
    @JoinColumn(name = "client_id")
    private Client user;*/
}

