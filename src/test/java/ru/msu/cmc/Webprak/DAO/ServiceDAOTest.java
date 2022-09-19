package ru.msu.cmc.Webprak.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.Webprak.models.Service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
        Service entity = new Service(result + 1, "lalala", 1L, 3000L,
                500L, 5.0, 422L);
        serviceDAO.save(entity);
        Service service = serviceDAO.getById(result + 1);
        notNull(service);
    }

    @Test
    void updateTest() {
        Service entity = new Service(1L,"bebebe", 1L, 3000L,
                700L, 5.0, 422L);
        serviceDAO.update(entity);
        Service service = serviceDAO.getById(1L);
        assertEquals(service, entity);
    }

}