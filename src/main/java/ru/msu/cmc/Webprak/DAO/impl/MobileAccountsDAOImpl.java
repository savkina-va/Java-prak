package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.ContractHistoryDAO;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;
import ru.msu.cmc.Webprak.DAO.ServiceDAO;
import ru.msu.cmc.Webprak.DAO.TransactionsDAO;
import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.Transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MobileAccountsDAOImpl extends ru.msu.cmc.Webprak.DAO.impl.CommonDAOImpl<MobileAccounts, Long> implements MobileAccountsDAO {

    public MobileAccountsDAOImpl(){
        super(MobileAccounts.class);
    }
    @Autowired
    private TransactionsDAO transactionsDAO = new TransactionsDAOImpl();

    @Autowired
    private ContractHistoryDAO contractHistoryDAO = new ContractHistoryDAOImpl();

    @Autowired
    private ServiceDAO serviceDAO = new ServiceDAOImpl();
    @Override
    public List<Transactions> getTransactions(Long telephoneNumber) {
        List<Transactions> ret = new ArrayList<>();
        for(Transactions transaction : transactionsDAO.getAll()) {
            if (Objects.equals(telephoneNumber, transaction.getMobileAccount().getId())) {
                ret.add(transaction);
            }
        }
        return ret;
    }

    @Override
    public List<ContractHistory> getHistory(Long telephoneNumber) {
        List<ContractHistory> ret = new ArrayList<>();
        for(ContractHistory contract : contractHistoryDAO.getAll()) {
            if (Objects.equals(telephoneNumber, contract.getMobileAccount().getId())) {
                ret.add(contract);
            }
        }
        return ret;
    }
}