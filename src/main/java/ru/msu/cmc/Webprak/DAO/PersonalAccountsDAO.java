package ru.msu.cmc.Webprak.DAO;

import ru.msu.cmc.Webprak.models.PersonalAccounts;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public interface PersonalAccountsDAO extends CommonDAO<PersonalAccounts, Long> {
    //List<PersonalAccounts> getByFilter(Filter filter);

}