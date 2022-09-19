package ru.msu.cmc.Webprak.DAO.impl;


import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.TransactionsDAO;
import ru.msu.cmc.Webprak.models.Transactions;

import java.sql.Date;

@Repository
public class TransactionsDAOImpl extends ru.msu.cmc.webprak.DAO.impl.CommonDAOImpl<Transactions, Long> implements TransactionsDAO {

}