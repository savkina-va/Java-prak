package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.ContractHistoryDAO;
import ru.msu.cmc.Webprak.DAO.ServiceDAO;
import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.Service;
import ru.msu.cmc.Webprak.models.Transactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class ContractHistoryDAOImpl extends ru.msu.cmc.Webprak.DAO.impl.CommonDAOImpl<ContractHistory, Long> implements ContractHistoryDAO {

    public ContractHistoryDAOImpl(){
        super(ContractHistory.class);
    }


    @Override
    public List<ContractHistory> filterByServiceId(Long serviceId){
        List<ContractHistory> ret = new ArrayList<>();
        for(ContractHistory contract : getAll()) {
            if (Objects.equals(serviceId, contract.getServiceId().getId())) {
                ret.add(contract);
            }
        }
        return ret;
    }
    @Override
    public List<ContractHistory> filterByDate(Date startDate, Date stopDate) {
        List<ContractHistory> ret = new ArrayList<>();
        for (ContractHistory contract : getAll()) {
            if (startDate.before(contract.getDateStart()) && stopDate.after(contract.getDateStop())) {
                ret.add(contract);
            }
        }
        return ret;
    }

//    @Override
//    public Boolean isCreditExceeded(Long contractId) {
//        ContractHistory contract = getById(contractId);
//        Long maxCredit = contract.getServiceId().getMaxCredit();
//        Long balance = contract.getMobileAccount().getBalance();
//        return (balance >= (-maxCredit));
//    }
}