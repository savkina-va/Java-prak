package ru.msu.cmc.Webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.msu.cmc.Webprak.DAO.PersonalAccountsDAO;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;

import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;
import ru.msu.cmc.Webprak.models.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonalAccountsDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<PersonalAccounts, Long> implements PersonalAccountsDAO {
    public PersonalAccountsDAOImpl(){
        super(PersonalAccounts.class);
    }

    private MobileAccountsDAO mobileAccountsDAO = new MobileAccountsDAOImpl();

    @Override
    public List<MobileAccounts> getMobileAccounts(Long clientId) {
        List<MobileAccounts> ret = new ArrayList<>();
        for(MobileAccounts mobileAccounts : mobileAccountsDAO.getAll()) {
            if (clientId.equals(mobileAccounts.getClientId().getId())) {
                ret.add(mobileAccounts);
            }
        }
        return ret;
    }
}

