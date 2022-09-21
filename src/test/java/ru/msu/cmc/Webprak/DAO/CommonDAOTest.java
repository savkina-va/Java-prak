package ru.msu.cmc.Webprak.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;
import ru.msu.cmc.Webprak.models.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class CommonDAOTest {
    @Autowired
    private ServiceDAO serviceDAO;

    @Autowired
    private MobileAccountsDAO mobileAccountsDAO;

    @Autowired
    private PersonalAccountsDAO personalAccountsDAO;

    @Autowired
    private SessionFactory sessionFactory;

    Long getLastId() {
        Long lastId = -1L;
        for(Service service : serviceDAO.getAll()) {
            lastId = Math.max(service.getId(), lastId);
        }
        return lastId;
    }

    void refillDB() {
        String fillDatabaseStr;
        String path = "./src/main/resources/sql/create_db.sql";
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            fillDatabaseStr = file.lines().collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery(fillDatabaseStr).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    void testGetById(){
        MobileAccounts trueMobileAccount =  new MobileAccounts(89999999999L, personalAccountsDAO.getById(1L),0L);
        assertEquals(trueMobileAccount, mobileAccountsDAO.getById(89999999999L));
    }

    @Test
    void testGetAll() {
        List<PersonalAccounts> actualPersonalAccounts = new ArrayList<>();

        actualPersonalAccounts.add(new PersonalAccounts(1L, "x", "x", "x", "x", "x"));
        actualPersonalAccounts.add(new PersonalAccounts(2L, "x", "x", "x", "x", "x"));
        personalAccountsDAO.saveCollection(actualPersonalAccounts);

        List<PersonalAccounts> personalAccounts = (List<PersonalAccounts>) personalAccountsDAO.getAll();
        assertEquals(actualPersonalAccounts, personalAccounts);
    }

    @Test
    void testSave() {
        Service newService = new Service(1L,"bebebe", 1L, 300.0, 700L, 5.0,  422L, 12L);
        serviceDAO.save(newService);
        assertEquals(serviceDAO.getById(1L), newService);
    }

    @Test
    void testSaveCollection() {
        List<PersonalAccounts> accounts = new ArrayList<>();
        accounts.add(new PersonalAccounts(1L, "x", "x", "x", "x", "x"));
        accounts.add(new PersonalAccounts(2L, "x", "x", "x", "x", "x"));
        personalAccountsDAO.saveCollection(accounts);
        assertEquals(accounts.get(0), personalAccountsDAO.getById(1L));
        assertEquals(accounts.get(1), personalAccountsDAO.getById(2L));
    }

    @Test
    void testUpdate() {
        PersonalAccounts newAccount = new PersonalAccounts(1L, "x", "x", "x", "x", "x");
        personalAccountsDAO.save(newAccount);
        personalAccountsDAO.update(newAccount);
        assertEquals(personalAccountsDAO.getById(1L), newAccount);
    }

    @Test
    void testDelete() {
        PersonalAccounts newAccount = new PersonalAccounts(1L, "x", "x", "x", "x", "x");
        personalAccountsDAO.save(newAccount);
        personalAccountsDAO.delete(newAccount);
        assertNull(personalAccountsDAO.getById(1L));
    }

    @Test
    void testDeleteById() {
        PersonalAccounts newAccount = new PersonalAccounts(2L, "x", "x", "x", "x", "x");
        personalAccountsDAO.save(newAccount);
        personalAccountsDAO.deleteById(2L);
        assertNull(personalAccountsDAO.getById(2L));
    }
}