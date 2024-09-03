package com.sash.budget_calculator.controllers;

import com.sash.budget_calculator.model.Expense;
import com.sash.budget_calculator.repositories.ExpenseRepository;
import com.sash.budget_calculator.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        return "expenses/expenses";
    }

    @GetMapping("/create")
    public String createExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expenses/create-expenses";
    }

    @PostMapping("/create")
    public String createExpense(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String editExpenseForm(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid expense id:" + id));
        model.addAttribute("expense", expense);
        return "expenses/edit-expenses";
    }

    @PostMapping("/edit/{id}")
    public String updateExpense(@PathVariable("id") Long id, @ModelAttribute Expense expense) {
        expense.setId(id);
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expenses";
    }
}


