package ru.msu.cmc.Webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.ServiceDAO;
import ru.msu.cmc.Webprak.models.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceDAOImpl extends CommonDAOImpl<Service, Long> implements ServiceDAO {

    public ServiceDAOImpl(){
        super(Service.class);
    }

    //@Override

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}