package ru.msu.cmc.Webprak.models;

import javax.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_history", schema = "public", catalog = "postgres")
public class ContractHistoryEntity {
    @Basic
    @Column(name = "contract_id")
    private int contractId;
    @Basic
    @Column(name = "mobile_account")
    private String mobileAccount;
    @Basic
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic
    @Column(name = "telephone_numbers")
    private String telephoneNumbers;
    @Basic
    @Column(name = "date_start")
    private Date dateStart;
    @Basic
    @Column(name = "date_stop")
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
        ContractHistoryEntity that = (ContractHistoryEntity) o;
        return contractId == that.contractId && Objects.equals(mobileAccount, that.mobileAccount) && Objects.equals(serviceId, that.serviceId) && Objects.equals(telephoneNumbers, that.telephoneNumbers) && Objects.equals(dateStart, that.dateStart) && Objects.equals(dateStop, that.dateStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, mobileAccount, serviceId, telephoneNumbers, dateStart, dateStop);
    }
}
