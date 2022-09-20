package ru.msu.cmc.Webprak.models;

import javax.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "transactions", schema = "public", catalog = "postgres")
public class Transactions implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @NonNull
    @Column(name = "type_of_transaction")
    private String typeOfTransaction;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mobile_account")
    private MobileAccounts mobileAccount;

    @NonNull
    @Column(name = "amount")
    private Long amount;

    @NonNull
    @Column(name = "date_of_transaction")
    private Date dateOfTransaction;
}
