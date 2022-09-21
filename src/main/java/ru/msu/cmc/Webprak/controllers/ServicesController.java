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
    public String servicePage(@RequestParam(name = "serviceId") Long serviceId, Model model) {
        Service service = serviceDAO.getById(serviceId);

        if (service == null) {
            model.addAttribute("error_msg", "В базе нет услуги с ID = " + serviceId);
            return "errorPage";
        }

        model.addAttribute("service", service);
        return "service";
    }

    @GetMapping("/editService")
    public String editPersonalAccountPage(@RequestParam(name = "serviceId", required = false) Long serviceId, Model model) {
        if (serviceId == null) {
            model.addAttribute("service", new Service());
            model.addAttribute("serviceDAO", serviceDAO);
            return "editService";
        }

        Service service = serviceDAO.getById(serviceId);

        if (service == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + serviceId);
            return "errorPage";
        }

        model.addAttribute("service", service);
        model.addAttribute("serviceDAO", serviceDAO);
        return "editService";
    }

    @PostMapping("/saveService")
    public String saveServicePage(@RequestParam(name = "serviceId", required = false) Long serviceId,
                                  @RequestParam(name = "serviceNameService") String serviceNameService,
                                  @RequestParam(name = "serviceNumberOfDevices") Long serviceNumberOfDevices,
                                  @RequestParam(name = "serviceMinutes") Double serviceMinutes,
                                  @RequestParam(name = "serviceSms") Long serviceSms,
                                  @RequestParam(name = "serviceInternet") Double serviceInternet,
                                  @RequestParam(name = "serviceTariffFee") Long serviceTariffFee,
                                  @RequestParam(name = "serviceMaxCredit") Long serviceMaxCredit,
                                Model model) {

        if (serviceId == null) {
            Long id = 1000L;
            Service service = new Service(id, serviceNameService, serviceNumberOfDevices, serviceMinutes, serviceSms, serviceInternet, serviceTariffFee, serviceMaxCredit);
            serviceDAO.save(service);
            return String.format("redirect:/service?serviceId=%d", service.getId());

        }
        else {
            Service service = serviceDAO.getById(serviceId);
            service.setNameService(serviceNameService);
            service.setNumberOfDevices(serviceNumberOfDevices);
            service.setMinutes(serviceMinutes);
            service.setSms(serviceSms);
            service.setInternet(serviceInternet);
            service.setTariffFee(serviceTariffFee);
            service.setMaxCredit(serviceMaxCredit);
            serviceDAO.update(service);
            return String.format("redirect:/service?serviceId=%d", service.getId());

        }
    }

    @PostMapping("/removeService")
    public String removeServicePage(@RequestParam(name = "serviceId") Long serviceId) {
        serviceDAO.deleteById(serviceId);
        return "redirect:/services";
    }
}
