package ru.msu.cmc.Webprak.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.Webprak.DAO.impl.MobileAccountsDAOImpl;
import ru.msu.cmc.Webprak.DAO.impl.PersonalAccountsDAOImpl;
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
    private PersonalAccountsDAO personalAccountsDAO = new PersonalAccountsDAOImpl();

    @Autowired
    private MobileAccountsDAO mobileAccountsDAO = new MobileAccountsDAOImpl();
    @Test
    void getMobileAccountsTest() {
//        PersonalAccounts personalAccount = new PersonalAccounts(42L, "x", "x", "x", "x", "x");
//        personalAccountsDAO.save(personalAccount);
//        MobileAccounts mobileAccount = new MobileAccounts(42L, personalAccount, 42L);
//        mobileAccountsDAO.save(mobileAccount);

        MobileAccounts mobileAccount = mobileAccountsDAO.getById(42L);
        List<MobileAccounts> getAccounts = personalAccountsDAO.getMobileAccounts(42L);
        assertEquals(getAccounts.get(0), mobileAccount);
    }
}