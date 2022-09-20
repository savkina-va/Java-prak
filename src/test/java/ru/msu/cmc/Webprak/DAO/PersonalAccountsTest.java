package ru.msu.cmc.Webprak.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;

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
public class PersonalAccountsTest {

    @Autowired
    private PersonalAccountsDAO personalAccountsDAO;

    @Autowired
    private SessionFactory sessionFactory;
    @Test
    void createTest() {
        Session session = sessionFactory.openSession();
        //Query query = session.createSQLQuery("select max(id) from service");

        //@SuppressWarnings("unchecked")
        //Long result = Long.valueOf((Integer) query.list().get(0));
        session.close();
        PersonalAccounts newPerson = new PersonalAccounts(18L,"Физическое лицо", "Максим", "Савкин", "Константинович", "krasavchik@mail.ru");
        personalAccountsDAO.save(newPerson);
        PersonalAccounts service = personalAccountsDAO.getById(18L);
        assertNull(service);
    }

    /*@Test
    void updateTest() {
        Service entity = new Service(1L,"bebebe", 1L, 3000L,
                700L, 5.0, 422L);
        serviceDAO.update(entity);
        Service service = serviceDAO.getById(1L);
        assertEquals(service, entity);
    }

    @Test
    void deleteTest() {
        Session session = sessionFactory.openSession();
        Service delService = serviceDAO.getById(18L);
        serviceDAO.delete(delService);
        assertNull(serviceDAO.getById(18L));
    }*/
    @Test
    void deleteByIdTest() {
        Session session = sessionFactory.openSession();
        personalAccountsDAO.deleteById(7L);
        assertNull(personalAccountsDAO.getById(7L));
    }

    @Test
    void getMobileAccountsTest() {
        Session session = sessionFactory.openSession();
        List<MobileAccounts> acc = personalAccountsDAO.getMobileAccounts(1L);
        //assertNull(personalAccountsDAO.getById(18L));
        System.out.println(acc);
    }

}