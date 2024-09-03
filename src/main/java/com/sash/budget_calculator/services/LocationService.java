package com.sash.budget_calculator.services;

import com.sash.budget_calculator.model.Housing;
import com.sash.budget_calculator.model.Location;
import com.sash.budget_calculator.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    public void saveLocation(Location location) {locationRepository.save(location);}

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

}
