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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @NonNull
    private PersonalAccounts clientId;
    @Id
    @Column(name = "telephone_number")
    private Long telephoneNumber;
    @NonNull
    @Column(name = "balance")
    private Long balance;

//    public Integer getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(Integer clientId) {
//        this.clientId = clientId;
//    }
//
//    public String getTelephoneNumber() {
//        return telephoneNumber;
//    }
//
//    public void setTelephoneNumber(String telephoneNumber) {
//        this.telephoneNumber = telephoneNumber;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//
//    public void setBalance(int balance) {
//        this.balance = balance;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileAccounts that = (MobileAccounts) o;
        return balance.equals(that.balance)
                && Objects.equals(clientId, that.clientId)
                && Objects.equals(telephoneNumber, that.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, telephoneNumber, balance);
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long aLong) {

    }
}
