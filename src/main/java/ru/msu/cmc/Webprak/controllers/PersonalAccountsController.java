package ru.msu.cmc.Webprak.controllers;


import ru.msu.cmc.Webprak.models.PersonalAccounts;
import ru.msu.cmc.Webprak.DAO.PersonalAccountsDAO;
import ru.msu.cmc.Webprak.DAO.impl.PersonalAccountsDAOImpl;


import ru.msu.cmc.Webprak.models.MobileAccounts;
import ru.msu.cmc.Webprak.DAO.MobileAccountsDAO;
import ru.msu.cmc.Webprak.DAO.impl.MobileAccountsDAOImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PersonalAccountsController {

    @Autowired
    private final PersonalAccountsDAO personalAccountsDAO = new PersonalAccountsDAOImpl();

    @Autowired
    private final MobileAccountsDAO mobileAccountsDAO = new MobileAccountsDAOImpl();


    @GetMapping("/personalAccounts")
    public String peopleListPage(Model model) {
        List<PersonalAccounts> clients = (List<PersonalAccounts>) personalAccountsDAO.getAll();
        model.addAttribute("clients", clients);

        return "personalAccounts";
    }

    @GetMapping("/personalAccount")
    public String clientPage(@RequestParam(name = "clientId") Long clientId, Model model) {
        PersonalAccounts client = personalAccountsDAO.getById(clientId);

        if (client == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + clientId);
            return "errorPage";
        }

        model.addAttribute("client", client);
        model.addAttribute("personalAccountsDAO", personalAccountsDAO);
        return "personalAccount";
    }

    @GetMapping("/errorPage")
    public String errorPage() {

        return "errorPage";
    }

    @GetMapping("/editPersonalAccount")
    public String editPersonalAccountPage(@RequestParam(name = "clientId", required = false) Long clientId, Model model) {
        if (clientId == null) {
            model.addAttribute("client", new PersonalAccounts());
            model.addAttribute("personalAccountsDAO", personalAccountsDAO);
            return "editPersonalAccount";
        }

        PersonalAccounts client = personalAccountsDAO.getById(clientId);

        if (client == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + clientId);
            return "errorPage";
        }

        model.addAttribute("client", client);
        model.addAttribute("personalAccountsDAO", personalAccountsDAO);
        return "editPersonalAccount";
    }

    @PostMapping("/savePersonalAccount")
    public String savePlacePage(@RequestParam(name = "clientId", required = false) Long clientId,
                                @RequestParam(name = "clientTypeOfClint") String clientTypeOfClint,
                                @RequestParam(name = "clientName") String clientName,
                                @RequestParam(name = "clientMiddleName") String clientMiddleName,
                                @RequestParam(name = "clientSurname") String clientSurname,
                                @RequestParam(name = "clientEmail") String clientEmail,
                                Model model) {

        if (clientId == null) {
            Long id = 1000L;
            PersonalAccounts client = new PersonalAccounts(id, clientTypeOfClint, clientName, clientMiddleName, clientSurname, clientEmail);
            personalAccountsDAO.save(client);
            return String.format("redirect:/personalAccount?clientId=%d", client.getId());

        }
        else {
            PersonalAccounts client = personalAccountsDAO.getById(clientId);
            client.setTypeOfClint(clientTypeOfClint);
            client.setName(clientName);
            client.setMiddleName(clientMiddleName);
            client.setSurname(clientSurname);
            client.setEmail(clientEmail);
            personalAccountsDAO.update(client);
            return String.format("redirect:/personalAccount?clientId=%d", client.getId());

        }
    }

    @PostMapping("/removePersonalAccount")
    public String removePersonalAccountPage(@RequestParam(name = "clientId") Long clientId) {
        personalAccountsDAO.deleteById(clientId);
        return "redirect:/personalAccounts";
    }


}
