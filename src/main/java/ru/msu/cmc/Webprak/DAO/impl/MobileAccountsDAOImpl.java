package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;
import ru.msu.cmc.Webprak.models.MobileAccounts;

@Repository
public class MobileAccountsDAOImpl extends CommonDAOImpl<MobileAccounts, Long> implements MobileAccountsDAO {

    public MobileAccountsDAOImpl(){
        super(MobileAccounts.class);
    }

    //@Override

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}