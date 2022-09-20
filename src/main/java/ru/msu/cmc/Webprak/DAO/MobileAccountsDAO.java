package ru.msu.cmc.Webprak.DAO;

import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.Transactions;

import java.util.List;


public interface MobileAccountsDAO extends CommonDAO<MobileAccounts, Long> {
    List<Transactions> getTransactions(Long telephoneNumber);
}
