package com.sash.budget_calculator.controllers;

import com.sash.budget_calculator.model.Housing;
import com.sash.budget_calculator.repositories.HousingRepository;
import com.sash.budget_calculator.services.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/housing")
public class HousingController {

    @Autowired
    private HousingService housingService;

    @GetMapping
    public String listHousing(Model model) {
        model.addAttribute("housingList", housingService.getAllHousing());
        return "housing/housing-list";
    }

    @GetMapping("/add")
    public String addHousingForm(Model model) {
        model.addAttribute("housing", new Housing());
        return "housing/add-housing";
    }

    @PostMapping("/save")
    public String saveHousing(@ModelAttribute Housing housing) {
        housingService.saveHousing(housing);
        return "redirect:/housing";
    }

    @GetMapping("/edit/{id}")
    public String editHousingForm(@PathVariable Long id, Model model) {
        model.addAttribute("housing", housingService.getHousingById(id).orElse(null));
        return "housing/edit-housing";
    }

    @PostMapping("/update")
    public String updateHousing(@ModelAttribute Housing housing) {
        housingService.saveHousing(housing);
        return "redirect:/housing";
    }

    @GetMapping("/delete/{id}")
    public String deleteHousing(@PathVariable Long id) {
        housingService.deleteHousing(id);
        return "redirect:/housing";
    }

    @Autowired
    private HousingRepository housingRepository;

    //NOT USED
    @GetMapping("/homePrices")
    public String getAverageHomePrices(Model model) {
        // fetching only the average home prices from the Housing repository
        List<Double> averageHomePrices = housingRepository.findAll().stream()
                .map(Housing::getAverageHomePrice)
                .collect(Collectors.toList());
        model.addAttribute("averageHomePrices", averageHomePrices);
        return "housing/homePriceSlider";
    }

}


