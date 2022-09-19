package ru.msu.cmc.Webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.PersonalAccauntsDAO;
import ru.msu.cmc.Webprak.DAO.impl.CommonDAOImpl;
import ru.msu.cmc.Webprak.models.PersonalAccaunts;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonalAccauntsDAOImpl extends CommonDAOImpl<Service, Long> implements ServiceDAO {

    public PersonalAccauntDAOImpl(){
        super(Service.class);
    }

    //@Override

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}