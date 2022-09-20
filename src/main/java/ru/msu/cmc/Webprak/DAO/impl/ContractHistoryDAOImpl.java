package ru.msu.cmc.Webprak.DAO.impl;

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

@Repository
public class ContractHistoryDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<ContractHistory, Long> implements ContractHistoryDAO {
    public ContractHistoryDAOImpl(){
        super(ContractHistory.class);
    }

    private ContractHistoryDAO contractHistoryDAO = new ContractHistoryDAOImpl();
    public List<ContractHistory> getServices(Long serviceId){
        List<ContractHistory> ret = new ArrayList<>();
        for(ContractHistory contract : contractHistoryDAO.getAll()) {
            if (serviceId.equals(contract.getServiceId().getId())) {
                ret.add(contract);
            }
        }
        return ret;
    }

    public List<ContractHistory> filterByDate(Date startDate, Date stopDate) {
        List<ContractHistory> ret = new ArrayList<>();
        for (ContractHistory contract : contractHistoryDAO.getAll()) {
            if (startDate.before(contract.getDateStart()) && stopDate.after(contract.getDateStop())) {
                ret.add(contract);
            }
        }
        return ret;
    }
}