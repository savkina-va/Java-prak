package ru.msu.cmc.Webprak.controllers;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.msu.cmc.Webprak.models.Transactions;
import ru.msu.cmc.Webprak.DAO.TransactionsDAO;
import ru.msu.cmc.Webprak.DAO.impl.TransactionsDAOImpl;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;
import ru.msu.cmc.Webprak.DAO.TransactionsDAO;
import ru.msu.cmc.Webprak.DAO.impl.MobileAccountsDAOImpl;
import ru.msu.cmc.Webprak.DAO.impl.TransactionsDAOImpl;
import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.models.Service;


@Controller
public class MobileAccountController {

    @Autowired
    private final MobileAccountsDAO mobileAccountDAO = new MobileAccountsDAOImpl();


    @GetMapping("/mobileAccount")
    public String servicePage(@RequestParam(name = "mobileAccountId") Long mobileAccountId, Model model) {
        MobileAccounts mobileAccount = mobileAccountDAO.getById(mobileAccountId);

        if (mobileAccount == null) {
            model.addAttribute("error_msg", "В базе нет услуги с ID = " + mobileAccountId);
            return "errorPage";
        }

        model.addAttribute("mobileAccount", mobileAccount);
        model.addAttribute("mobileAccountDAO", mobileAccountDAO);
        return "mobileAccount";
    }
}
