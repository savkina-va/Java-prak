package ru.msu.cmc.Webprak.DAO;

import java.util.Date;
import java.util.List;

import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.models.Service;

public interface ContractHistoryDAO extends CommonDAO<ContractHistory, Long> {
    List<ContractHistory> getServices(Long serviceId);

    List<ContractHistory> filterByDate(java.util.Date startDate, Date stopDate);

//    Boolean isCreditExceeded(Long contractId);
}
