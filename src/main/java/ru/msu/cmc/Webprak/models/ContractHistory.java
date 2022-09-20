package ru.msu.cmc.Webprak.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "contract_history", schema = "public", catalog = "postgres")
public class ContractHistory implements CommonEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mobile_account")
    @NonNull
    private MobileAccounts mobileAccount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    @NonNull
    private Service serviceId;
    @NonNull
    @Column(name = "telephone_numbers")
    private String telephoneNumbers;
    @NonNull
    @Column(name = "date_start")
    private Date dateStart;
    @NonNull
    @Column(name = "date_stop")
    private Date dateStop;
}
