package ru.msu.cmc.Webprak.DAO;

import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;

import java.util.List;


public interface PersonalAccountsDAO extends CommonDAO<PersonalAccounts, Long> {
    List<MobileAccounts> getMobileAccounts(Long clientId);
}
