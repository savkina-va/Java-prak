package ru.msu.cmc.Webprak.controllers;


import lombok.NonNull;
import ru.msu.cmc.Webprak.models.ContractHistory;
import ru.msu.cmc.Webprak.DAO.ContractHistoryDAO;
import ru.msu.cmc.Webprak.DAO.impl.ContractHistoryDAOImpl;

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
public class ContractHistoryController {

    @Autowired
    private final ContractHistoryDAO contractHistoryDAO = new ContractHistoryDAOImpl();

    @GetMapping("/contractHistory")
    public String servicesListPage(@RequestParam(value = "service", required = false) Long serviceId,
                                   @NonNull Model model) {
        Long Id = 1L;
        if (serviceId!=null) {
            List<ContractHistory> contracts = contractHistoryDAO.filterByServiceId(serviceId);
            model.addAttribute("contracts", contracts);
        }
        else{
            List<ContractHistory> contracts = (List<ContractHistory>) contractHistoryDAO.getAll();
            model.addAttribute("contracts", contracts);
        }


        return "contractHistory";
    }
}
