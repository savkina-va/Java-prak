package ru.msu.cmc.Webprak.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import ru.msu.cmc.Webprak.DAO.impl.MobileAccountsDAOImpl;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.PersonalAccounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public interface PersonalAccountsDAO extends CommonDAO<PersonalAccounts, Long> {
    List<MobileAccounts> getMobileAccounts(Long clientId);
}
