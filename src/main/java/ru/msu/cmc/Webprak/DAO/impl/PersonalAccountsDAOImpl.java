package ru.msu.cmc.Webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import ru.msu.cmc.Webprak.DAO.PersonalAccountsDAO;
import ru.msu.cmc.Webprak.DAO.ServiceDAO;

import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;
import ru.msu.cmc.Webprak.models.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonalAccountsDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<PersonalAccounts, Long> implements PersonalAccountsDAO {
    public PersonalAccountsDAOImpl(){
        super(PersonalAccounts.class);
    }


    @Override
    public List<MobileAccounts> getMobileAccounts(Long clientId) {
        try (Session session = sessionFactory.openSession()) {
            Query<MobileAccounts> query = session.createQuery("select * from mobile_accounts where mobile_accounts.client_id==:clientID", MobileAccounts.class)
                    .setParameter("clientID", clientId);
            return query.getResultList();
        }
    }
}

