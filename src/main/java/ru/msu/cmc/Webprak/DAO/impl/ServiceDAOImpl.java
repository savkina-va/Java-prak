package ru.msu.cmc.Webprak.DAO.impl;


import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.ServiceDAO;
import ru.msu.cmc.Webprak.models.Service;

@Repository
public class ServiceDAOImpl extends ru.msu.cmc.Webprak.DAO.impl.CommonDAOImpl<Service, Long> implements ServiceDAO {
    public ServiceDAOImpl() {
        super(Service.class);
    }
};