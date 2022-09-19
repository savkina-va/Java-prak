package ru.msu.cmc.Webprak.DAO;

import java.sql.Date;

public class ContractHistoryDAO {
    private int contractId;
    private String mobileAccount;
    private Integer serviceId;
    private String telephoneNumbers;
    private Date dateStart;
    private Date dateStop;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getMobileAccount() {
        return mobileAccount;
    }

    public void setMobileAccount(String mobileAccount) {
        this.mobileAccount = mobileAccount;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(String telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateStop() {
        return dateStop;
    }

    public void setDateStop(Date dateStop) {
        this.dateStop = dateStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractHistoryDAO that = (ContractHistoryDAO) o;

        if (contractId != that.contractId) return false;
        if (mobileAccount != null ? !mobileAccount.equals(that.mobileAccount) : that.mobileAccount != null)
            return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (telephoneNumbers != null ? !telephoneNumbers.equals(that.telephoneNumbers) : that.telephoneNumbers != null)
            return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;
        if (dateStop != null ? !dateStop.equals(that.dateStop) : that.dateStop != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractId;
        result = 31 * result + (mobileAccount != null ? mobileAccount.hashCode() : 0);
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (telephoneNumbers != null ? telephoneNumbers.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateStop != null ? dateStop.hashCode() : 0);
        return result;
    }
}
