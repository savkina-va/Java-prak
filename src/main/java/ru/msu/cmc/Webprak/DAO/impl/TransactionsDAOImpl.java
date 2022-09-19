package ru.msu.cmc.Webprak.DAO.impl;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.TransactionsDAO;
import ru.msu.cmc.Webprak.models.Transactions;

import java.sql.Date;
import java.util.List;
import com.google.common.collect.Lists;

import java.sql.Timestamp;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TransactionsDAOImpl extends CommonDAOImpl<Transactions, Long> implements TransactionsDAO {

    public TransactionsDAOImpl(){
        super(Transactions.class);
    }

//    public List<Map<Date, Map<Long, String>>> getReport(Long number,
//                                                        Timestamp start,
//                                                        Timestamp end) {
//
//        List<Transactions> transactions =
//                this.filter(Map.of("numberFilter", Lists.newArrayList(number)),
//                        Transactions.class);
//
//        return transactions.stream()
//                .filter(tr -> tr.getDateOfTransaction().before(end) && tr.getDateOfTransaction().after(start))
//                .map(tr -> Map.of(tr.getDateOfTransaction(), Map.of(tr.getAmount(), tr.getTypeOfTransaction())))
//                .collect(Collectors.toList());
//
//    }
}