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
        List<ContractHistory> getHistory = contractHistoryDAO.filterByServiceId(4L);
        assertEquals(getHistory.get(0), contractHistoryDAO.getById(1L));
    }


    @Test
    void testisCreditExceeded(){

    }
}
