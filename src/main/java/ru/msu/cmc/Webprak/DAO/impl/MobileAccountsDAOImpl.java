package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;
import ru.msu.cmc.Webprak.models.MobileAccounts;

@Repository
public class MobileAccountsDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<MobileAccounts, Long> implements MobileAccountsDAO {
    public MobileAccountsDAOImpl(){
        super(MobileAccounts.class);
    }
}