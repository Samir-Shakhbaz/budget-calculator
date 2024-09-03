package com.sash.budget_calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/affordability")
    public String getAffordabilityPage(Model model) {
        // Initialize default values or fetch from the database if needed
        model.addAttribute("housePrice", 300000);
        model.addAttribute("monthlySalary", 5000);
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
