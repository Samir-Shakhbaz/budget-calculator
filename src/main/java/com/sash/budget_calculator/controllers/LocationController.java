package com.sash.budget_calculator.controllers;

import com.sash.budget_calculator.model.Location;
import com.sash.budget_calculator.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String listLocations(Model model) {
        model.addAttribute("locationList", locationService.getAllLocations());
        return "locations/locations-list";
    }

    @GetMapping("/add")
    public String addLocationForm(Model model) {
        model.addAttribute("location", new Location());
        return "locations/add-locations";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/edit/{id}")
    public String editLocationForm(@PathVariable Long id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id).orElse(null));
        return "locations/edit-locations";
    }

    @PostMapping("/update")
    public String updateLocation(@ModelAttribute Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }
}
