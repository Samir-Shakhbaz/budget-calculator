package com.sash.budget_calculator.services;

import com.sash.budget_calculator.model.Housing;
import com.sash.budget_calculator.repositories.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousingService {

    @Autowired
    private HousingRepository housingRepository;

    public List<Housing> getAllHousing() {
        return housingRepository.findAll();
    }

    public Optional<Housing> getHousingById(Long id) {
        return housingRepository.findById(id);
    }

    public Housing createHousing(Housing housing) {
        return housingRepository.save(housing);
    }

    public void deleteHousing(Long id) {
        housingRepository.deleteById(id);
    }
}
