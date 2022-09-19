package ru.msu.cmc.Webprak.DAO;

import java.sql.Date;

public class TransactionsDAO {
    private int transactionId;
    private String typeOfTransaction;
    private String mobileAccount;
    private int amount;
    private Date dateOfTransaction;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getMobileAccount() {
        return mobileAccount;
    }

    public void setMobileAccount(String mobileAccount) {
        this.mobileAccount = mobileAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionsDAO that = (TransactionsDAO) o;

        if (transactionId != that.transactionId) return false;
        if (amount != that.amount) return false;
        if (typeOfTransaction != null ? !typeOfTransaction.equals(that.typeOfTransaction) : that.typeOfTransaction != null)
            return false;
        if (mobileAccount != null ? !mobileAccount.equals(that.mobileAccount) : that.mobileAccount != null)
            return false;
        if (dateOfTransaction != null ? !dateOfTransaction.equals(that.dateOfTransaction) : that.dateOfTransaction != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionId;
        result = 31 * result + (typeOfTransaction != null ? typeOfTransaction.hashCode() : 0);
        result = 31 * result + (mobileAccount != null ? mobileAccount.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (dateOfTransaction != null ? dateOfTransaction.hashCode() : 0);
        return result;
    }
}
