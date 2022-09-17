package ru.msu.cmc.Webprak.models;

import javax.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Table(name = "mobile_accounts", schema = "public", catalog = "postgres")
public class MobileAccountsEntity {
    @Basic
    @Column(name = "client_id")
    private Integer clientId;
    @Basic
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Basic
    @Column(name = "balance")
    private int balance;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileAccountsEntity that = (MobileAccountsEntity) o;
        return balance == that.balance && Objects.equals(clientId, that.clientId) && Objects.equals(telephoneNumber, that.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, telephoneNumber, balance);
    }
}
