package com.sash.budget_calculator.controllers;

import com.sash.budget_calculator.repositories.ExpenseRepository;
import com.sash.budget_calculator.repositories.HousingRepository;
import com.sash.budget_calculator.repositories.LocationRepository;
import com.sash.budget_calculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private HousingRepository housingRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/summary")
    public String summary(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        model.addAttribute("housings", housingRepository.findAll());
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "summary";
    }

}

