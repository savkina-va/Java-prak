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

//    @RequestMapping(value = "/personalAccounts", method = RequestMethod.POST)
//    public String getClients(Model model) {
//        PersonalAccounts accounts = new PersonalAccounts();
//        model.addAttribute("accounts", accounts);
//        return "client/client";
//    }

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

//    @GetMapping("/editPersonalAccount")
//    public String editPersonPage(@RequestParam(name = "personId", required = false) Long personId, Model model) {
//        if (personId == null) {
//            model.addAttribute("person", new PersonalAccounts());
//            return "editPersonalAccount";
//        }
//
//        PersonalAccounts person = personalAccountsDAO.getById(personId);
//
//        /*if (person == null) {
//            model.addAttribute("error_msg", "В базе нет человека с ID = " + personId);
//            return "errorPage";
//        }*/
//
//        model.addAttribute("person", person);
//        return "editPersonalAccount";
//    }
//
//    @GetMapping("/client")
//    public String clientPage(@RequestParam(name = "clientId") Long clientId, Model model) {
//        PersonalAccounts client = personalAccountsDAO.getById(clientId);
//
////        if (client == null) {
////            model.addAttribute("error_msg", "В базе нет человека с ID = " + clientId);
////            return "errorPage";
////        }
//
//        model.addAttribute("client", client);
//        return "client";
//    }

//    @GetMapping("/person")
//    public String personPage(@RequestParam(name = "personId") Long personId, Model model) {
//        PersonalAccounts person = PersonalAccountsDAO.getById(personId);
//
//        if (person == null) {
//            model.addAttribute("error_msg", "В базе нет человека с ID = " + personId);
//            return "errorPage";
//        }
//
//        model.addAttribute("person", person);
//        model.addAttribute("personService", personDAO);
//        model.addAttribute("placeService", placeDAO);
//        model.addAttribute("person2placeService", person2PlaceDAO);
//        model.addAttribute("relationService", relationDAO);
//        return "person";
//    }


//    @RequestMapping(value = "/filter_clients", method = RequestMethod.GET)
//    public String filterSortClients(@RequestParam(name = "name_filter") String name_filter,
//                                    @RequestParam(name = "sort") String sort,
//                                    Model model) {
//        ClientDAO clientDAO = new ClientDAO();
//        List<Client> result;
//        if (Objects.nonNull(name_filter)) {
//            result = clientDAO.getAll(Client.class).stream()
//                    .filter(client -> client.getName().contains(name_filter))
//                    .collect(Collectors.toList());
//        } else {
//            result = clientDAO.getAll(Client.class);
//        }
//        if (Objects.nonNull(sort)) {
//            if (sort.equals("По возрастанию")) {
//                result.sort(Comparator.comparing(Client::getName));
//            } else if (sort.equals("По убыванию")) {
//                result.sort((Client o1, Client o2) ->
//                        o2.getName().compareTo(o1.getName()));
//            }
//        }
//        model.addAttribute("clients", result);
//        return "client/client";
//    }
//
//    @RequestMapping(value = "/client/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//        return "client/registration";
//    }
//
//    @RequestMapping(value = "/add_client", method = RequestMethod.GET)
//    public String addClient(@RequestParam(name = "fcn", required = true) String fcn,
//                            @RequestParam(name = "type") String type,
//                            @RequestParam(name = "address") String address,
//                            @RequestParam(name = "email") String email,
//                            Model model) {
//
//        try {
//            ClientDAO clientDAO = new ClientDAO();
//            long id = clientDAO.getAll(Client.class).stream()
//                    .map(Client::getId).max(Long::compareTo).orElse(0L) + 1;
//            Client client = new Client(id, fcn, type, address, email);
//            clientDAO.create(client);
//            String res = String.format("Client added successfully with id = %d", id);
//            model.addAttribute("id", id);
//            model.addAttribute("msg",
//                    res);
//            return "successful";
//        } catch (Exception e) {
//            model.addAttribute("error",
//                    "Can't create client.");
//            return "error";
//        }
//
//    }
//
//    @RequestMapping(value = "/update_client", method = RequestMethod.GET)
//    public String updateClient(@RequestParam(name = "id", required = true) Long id,
//                            @RequestParam(name = "fcn", required = true) String fcn,
//                            @RequestParam(name = "type") String type,
//                            @RequestParam(name = "address") String address,
//                            @RequestParam(name = "email") String email,
//                            Model model) {
//
//        try {
//            ClientDAO clientDAO = new ClientDAO();
//            Client client = new Client(id, fcn, type, address, email);
//            clientDAO.update(client);
//            String res = String.format("Client updated successfully with id = %d", id);
//            model.addAttribute("msg",
//                    res);
//            return "successful";
//        } catch (Exception e) {
//            model.addAttribute("error",
//                    "Can't update client.");
//            return "error";
//        }
//
//    }
//
//    @RequestMapping(value = "/client_page", method = RequestMethod.GET)
//    public String pageClient(@RequestParam(name = "id", required = true) Long id,
//                               Model model) {
//        ClientDAO clientDAO = new ClientDAO();
//        Client client = clientDAO.getEntityById(id, Client.class);
//        model.addAttribute("client",
//                client);
//        return "client/client_page";
//    }
//
//    @RequestMapping(value = "/delete_client", method = RequestMethod.GET)
//    public String deleteClient(@RequestParam(name = "id", required = true) Long id,
//                               Model model) {
//
//        try {
//            ClientDAO clientDAO = new ClientDAO();
//            Client client = clientDAO.getEntityById(id, Client.class);
//            clientDAO.delete(client);
//            String res = String.format("Client deleted successfully with id = %d", id);
//            model.addAttribute("msg",
//                    res);
//            return "successful";
//        } catch (Exception e) {
//            model.addAttribute("error",
//                    "Can't delete client.");
//            return "error";
//        }
//
//    }


}
