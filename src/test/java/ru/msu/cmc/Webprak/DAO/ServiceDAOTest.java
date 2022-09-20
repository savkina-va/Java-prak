package ru.msu.cmc.Webprak.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.Webprak.models.Service;


import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;


import static org.springframework.util.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class ServiceDAOTest {

    @Autowired
    private ServiceDAO serviceDAO;
    @Autowired
    private SessionFactory sessionFactory;
    @Test
    void createTest() {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select max(id) from service");

        @SuppressWarnings("unchecked")
        Long result = Long.valueOf((Integer) query.list().get(0));
        session.close();
        Service entity = new Service(1000L, "lalala", 1L, 3000.0, 10000L,
                500.0, "minecraft", 422L);
        serviceDAO.save(entity);
        Service service = serviceDAO.getById(1000L);
        assertEquals(service, entity);
    }

    @Test
    void updateTest() {
        Service entity = new Service(1L,"bebebe", 1L, 300.0, 700L, 5.0, "lalala",422L);
        serviceDAO.update(entity);
        Service service = serviceDAO.getById(1L);
        assertEquals(service, entity);
    }

}