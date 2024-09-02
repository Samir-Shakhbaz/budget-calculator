package com.sash.budget_calculator.controllers;

import com.sash.budget_calculator.model.Housing;
import com.sash.budget_calculator.services.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/housing")
public class HousingController {

    @Autowired
    private HousingService housingService;

    @GetMapping
    public List<Housing> getAllHousing() {
        return housingService.getAllHousing();
    }

    @GetMapping("/{id}")
    public Optional<Housing> getHousingById(@PathVariable Long id) {
        return housingService.getHousingById(id);
    }

    @PostMapping
    public Housing createHousing(@RequestBody Housing housing) {
        return housingService.createHousing(housing);
    }

    @DeleteMapping("/{id}")
    public void deleteHousing(@PathVariable Long id) {
        housingService.deleteHousing(id);
    }
}

