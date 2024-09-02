package com.sash.budget_calculator.repositories;

import com.sash.budget_calculator.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}

