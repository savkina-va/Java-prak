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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        MobileAccounts trueMobileAccount =  new MobileAccounts(1L, personalAccountsDAO.getById(89999999999L),0L);
        assertEquals(trueMobileAccount, mobileAccountsDAO.getById(89999999999L));
    }

    @Test
    void testGetAll() {
        List<MobileAccounts> actualMobileAccounts = new ArrayList<>();
        actualMobileAccounts.add(new MobileAccounts(1L, personalAccountsDAO.getById(89999999999L),0L));
        actualMobileAccounts.add(new MobileAccounts(2L, personalAccountsDAO.getById(89162222222L),0L));
        actualMobileAccounts.add(new MobileAccounts(3L, personalAccountsDAO.getById(89061231231L),0L));
        actualMobileAccounts.add(new MobileAccounts(4L, personalAccountsDAO.getById(89031020512L),0L));
        actualMobileAccounts.add(new MobileAccounts(5L, personalAccountsDAO.getById(84991234568L),0L));
        actualMobileAccounts.add(new MobileAccounts(6L, personalAccountsDAO.getById(84991234567L),0L));
        actualMobileAccounts.add(new MobileAccounts(4L, personalAccountsDAO.getById(84991230067L),0L));
        actualMobileAccounts.add(new MobileAccounts(3L, personalAccountsDAO.getById(84991234569L),0L));
        actualMobileAccounts.add(new MobileAccounts(3L, personalAccountsDAO.getById(89064242427L),0L));
        actualMobileAccounts.add(new MobileAccounts(3L, personalAccountsDAO.getById(79061231232L),0L));

        List<MobileAccounts> mobileAccounts = (List<MobileAccounts>) mobileAccountsDAO.getAll();
        assertEquals(actualMobileAccounts, mobileAccounts);
    }

    @Test
    void testSave() {
        Service newService = new Service(1000L,"bebebe", 1L, 300.0, 700L, 5.0, "lalala", 422L, 12L);
        serviceDAO.save(newService);
        assertEquals(serviceDAO.getById(1000L), newService);
    }

    @Test
    void testSaveCollection() {
        List<Service> services = new ArrayList<>();
        services.add(new Service("test service 1" ,2L,300.0,300L,30.0,840L, 500L));
        services.add(new Service("test service 2" ,2L,300.0,300L,30.0,840L, 500L));
        serviceDAO.saveCollection(services);
        assertEquals(services.get(0), serviceDAO.getById(getLastId() + 1));
        assertEquals(services.get(1), serviceDAO.getById(getLastId() + 2));
    }

    @Test
    void testUpdate() {
        Service updatedService = new Service(1L,"bebebe", 1L, 300.0, 700L, 5.0, "lalala", 422L, 12L);
        serviceDAO.update(updatedService);
        assertEquals(serviceDAO.getById(1L), updatedService);
    }

    @Test
    void testDelete() {
        serviceDAO.delete(new Service("Студенческий", 1L, 300.0, 150L, 20.0, 400L, 300L));
        assertNull(serviceDAO.getById(1L));
    }

    @Test
    void testDeleteById() {
        Long id = 4L;
        serviceDAO.deleteById(id);
        assertNull(serviceDAO.getById(id));
    }
}