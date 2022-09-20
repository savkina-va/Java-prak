package ru.msu.cmc.Webprak.DAO;

import java.util.Date;
import java.util.List;

import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.models.Service;

public interface ContractHistoryDAO extends CommonDAO<ContractHistory, Long> {
    List<ContractHistory> filterByServiceId(Long serviceId);

//    List<ContractHistory> filterByDate(Date startDate, Date stopDate);

//    Boolean isCreditExceeded(Long contractId);
}
