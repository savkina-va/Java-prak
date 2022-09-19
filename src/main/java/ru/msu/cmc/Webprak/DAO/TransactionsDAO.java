package ru.msu.cmc.Webprak.DAO;

import ru.msu.cmc.Webprak.models.Transactions;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface TransactionsDAO extends CommonDAO<Transactions, Long> {

//    public List<Map<Date, Map<Long, String>>> getReport(Long number,
//                                                        Timestamp start,
//                                                        Timestamp end);
}