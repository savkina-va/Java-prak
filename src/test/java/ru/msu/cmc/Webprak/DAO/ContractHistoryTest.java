package ru.msu.cmc.Webprak.DAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.msu.cmc.Webprak.DAO.impl.ContractHistoryDAOImpl;
import ru.msu.cmc.Webprak.DAO.impl.ServiceDAOImpl;
import ru.msu.cmc.Webprak.models.ContractHistory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractHistoryTest {
    @Autowired
    ServiceDAO serviceDAO = new ServiceDAOImpl();
    @Autowired
    ContractHistoryDAO contractHistoryDAO = new ContractHistoryDAOImpl();

    @Test
    void testFilterByServiceId(){
        List<ContractHistory> getTransaction = contractHistoryDAO.filterByServiceId(42L);
        assertEquals(getTransaction.get(0), contractHistoryDAO.getById(42L));
    }

    @Test
    void testFilterByDate(){

    }

    @Test
    void testisCreditExceeded(){

    }
}
