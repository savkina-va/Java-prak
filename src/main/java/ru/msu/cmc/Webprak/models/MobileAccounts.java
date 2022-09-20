package ru.msu.cmc.Webprak.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;




@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "mobile_accounts", schema = "public", catalog = "postgres")
public class MobileAccounts implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "telephone_number")
    private Long telephoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @NonNull
    private PersonalAccounts clientId;

    @NonNull
    @Column(name = "balance")
    private Long balance;

    @Override
    public Long getId() {
        return telephoneNumber;
    }

    @Override
    public void setId(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
