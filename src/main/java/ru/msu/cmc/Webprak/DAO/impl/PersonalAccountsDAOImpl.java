package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.PersonalAccountsDAO;
import ru.msu.cmc.Webprak.models.PersonalAccounts;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonalAccountsDAOImpl extends CommonDAOImpl<PersonalAccounts, Long> implements PersonalAccountsDAO {

    public PersonalAccountsDAOImpl(){
        super(PersonalAccounts.class);
    }

//    @Override
//    public List<PersonalAccounts> getByFilter(Filter filter) {
//        try (Session session = sessionFactory.openSession()) {
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<PersonalAccounts> criteriaQuery = builder.createQuery(PersonalAccounts.class);
//            Root<PersonalAccounts> root = criteriaQuery.from(PersonalAccounts.class);
//
//            List<Predicate> predicates = new ArrayList<>();
//            if (filter.getName() != null)
//                predicates.add(builder.like(root.get("name"), likeExpr(filter.getName())));
//
//            if (predicates.size() != 0)
//                criteriaQuery.where(predicates.toArray(new Predicate[0]));
//
//            return session.createQuery(criteriaQuery).getResultList();
//        }
//    }
//    private String likeExpr(String param) {
//        return "%" + param + "%";
//    }
}