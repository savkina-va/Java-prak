package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.ContractHistoryDAO;
import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.models.PersonalAccounts;

import java.sql.Date;

@Repository
public class ContractHistoryDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<ContractHistory, Long> implements ContractHistoryDAO {
    public ContractHistoryDAOImpl(){
        super(ContractHistory.class);
    }
}