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
    @Column(name = "transaction_id")
    private Long transactionId;

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

//    public int getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(int transactionId) {
//        this.transactionId = transactionId;
//    }
//
//    public String getTypeOfTransaction() {
//        return typeOfTransaction;
//    }
//
//    public void setTypeOfTransaction(String typeOfTransaction) {
//        this.typeOfTransaction = typeOfTransaction;
//    }
//
//    public String getMobileAccount() {
//        return mobileAccount;
//    }
//
//    public void setMobileAccount(String mobileAccount) {
//        this.mobileAccount = mobileAccount;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public Date getDateOfTransaction() {
//        return dateOfTransaction;
//    }
//
//    public void setDateOfTransaction(Date dateOfTransaction) {
//        this.dateOfTransaction = dateOfTransaction;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(transactionId, that.transactionId)
                && amount.equals(that.amount)
                && Objects.equals(typeOfTransaction, that.typeOfTransaction)
                && Objects.equals(mobileAccount, that.mobileAccount)
                && Objects.equals(dateOfTransaction, that.dateOfTransaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, typeOfTransaction, mobileAccount, amount, dateOfTransaction);
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long aLong) {

    }
}
