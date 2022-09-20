package ru.msu.cmc.Webprak.controllers;


import ru.msu.cmc.Webprak.models.PersonalAccounts;
import ru.msu.cmc.Webprak.models.Service;
import ru.msu.cmc.Webprak.DAO.ServiceDAO;
import ru.msu.cmc.Webprak.DAO.impl.ServiceDAOImpl;

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
public class ServicesController {

    @Autowired
    private final ServiceDAO serviceDAO = new ServiceDAOImpl();

    @GetMapping("/services")
    public String servicesListPage(Model model) {
        List<Service> services = (List<Service>) serviceDAO.getAll();
        model.addAttribute("services", services);

        return "services";
    }

    @GetMapping("/service")
    public String clientPage(@RequestParam(name = "serviceId") Long serviceId, Model model) {
        Service service = serviceDAO.getById(serviceId);

        if (service == null) {
            model.addAttribute("error_msg", "В базе нет услуги с ID = " + serviceId);
            return "errorPage";
        }

        model.addAttribute("service", service);
        return "service";
    }
}
