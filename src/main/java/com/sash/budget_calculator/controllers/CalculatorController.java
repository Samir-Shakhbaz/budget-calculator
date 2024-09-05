package com.sash.budget_calculator.controllers;

import com.sash.budget_calculator.model.Housing;
import com.sash.budget_calculator.repositories.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CalculatorController {

    @Autowired
    private HousingRepository housingRepository;

    @GetMapping("/affordability")
    public String getAffordabilityPage(Model model) {
        // initializing default values
        model.addAttribute("housePrice", 300000);
        model.addAttribute("monthlySalary", 5000);

        List<Housing> housingList = housingRepository.findAll();
        model.addAttribute("housingList", housingList);
        return "affordability";
    }

    @PostMapping("/calculate")
    public String calculateAffordability(@RequestParam double housePrice, @RequestParam double monthlySalary, Model model) {
        // Calculate affordability
        double monthlyPayment = (housePrice / 30) / 12; // Example calculation
        double percentageOfIncome = (monthlyPayment / monthlySalary) * 100;

        model.addAttribute("housePrice", housePrice);
        model.addAttribute("monthlySalary", monthlySalary);
        model.addAttribute("monthlyPayment", monthlyPayment);
        model.addAttribute("percentageOfIncome", percentageOfIncome);

        return "affordability";
    }

}
