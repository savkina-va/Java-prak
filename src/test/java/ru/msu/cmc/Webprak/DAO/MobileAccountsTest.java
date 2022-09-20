package ru.msu.cmc.Webprak.DAO;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.Webprak.DAO.impl.ContractHistoryDAOImpl;
import ru.msu.cmc.Webprak.DAO.impl.MobileAccountsDAOImpl;
import ru.msu.cmc.Webprak.DAO.impl.PersonalAccountsDAOImpl;
import ru.msu.cmc.Webprak.DAO.impl.TransactionsDAOImpl;
import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;
import ru.msu.cmc.Webprak.models.Transactions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class MobileAccountsTest {

    @Autowired
    MobileAccountsDAO mobileAccountsDAO = new MobileAccountsDAOImpl();

    @Autowired
    TransactionsDAO transactionsDAO = new TransactionsDAOImpl();

    @Autowired
    private PersonalAccountsDAO personalAccountsDAO = new PersonalAccountsDAOImpl();

    @Autowired
    private ContractHistoryDAO contractHistoryDAO = new ContractHistoryDAOImpl();

    @Test
    void TestGetTransactions() throws ParseException {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        Date date = formatter.parse("7-Jun-2010");
//
//        PersonalAccounts personalAccount = new PersonalAccounts(42L, "x", "x", "x", "x", "x");
//        personalAccountsDAO.save(personalAccount);
//        MobileAccounts mobileAccount = new MobileAccounts(42L, personalAccount, 42L);
//        mobileAccountsDAO.save(mobileAccount);
//        Transactions transaction = new Transactions(42L, "x", mobileAccount, 42L, date);
//        transactionsDAO.save(transaction);

        Transactions transaction = transactionsDAO.getById(42L);
        List<Transactions> getTransaction = mobileAccountsDAO.getTransactions(42L);
        assertEquals(getTransaction.get(0), transaction);
    }

    @Test
    void testGetHistory() {
        ContractHistory contractHistory = contractHistoryDAO.getById(42L);
        List<ContractHistory> getHistory = mobileAccountsDAO.getHistory(42L);
        assertEquals(getHistory.get(0), contractHistory);
    }
}