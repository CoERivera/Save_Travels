package com.christopherrivera.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.christopherrivera.savetravels.models.Expense;
import com.christopherrivera.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String expensesRedirect() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.saveExpense(expense);
		}
		return "redirect:/expenses";

	}

	@GetMapping("/expenses/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "showExpense.jsp";
	}
	
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "editExpense.jsp";
	}

	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "show.jsp";
		} else {
			expenseService.saveExpense(expense);
			return "redirect:/expenses";
		}
	}
	
    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}
