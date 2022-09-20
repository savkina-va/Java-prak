package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;
import ru.msu.cmc.Webprak.DAO.TransactionsDAO;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.Transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MobileAccountsDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<MobileAccounts, Long> implements MobileAccountsDAO {
    public MobileAccountsDAOImpl(){
        super(MobileAccounts.class);
    }

    private TransactionsDAO transactionsDAO = new TransactionsDAOImpl();
    @Override
    public List<Transactions> getTransactions(Long telephoneNumber) {
        List<Transactions> ret = new ArrayList<>();
        for(Transactions transaction : transactionsDAO.getAll()) {
            if (telephoneNumber.equals(transaction.getMobileAccount().getTelephoneNumber())) {
                ret.add(transaction);
            }
        }
        return ret;
    }
}