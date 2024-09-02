package com.sash.budget_calculator.repositories;

import com.sash.budget_calculator.model.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingRepository extends JpaRepository<Housing, Long> {

}

