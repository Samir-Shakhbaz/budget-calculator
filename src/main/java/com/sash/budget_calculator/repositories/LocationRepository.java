package com.sash.budget_calculator.repositories;

import com.sash.budget_calculator.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}

