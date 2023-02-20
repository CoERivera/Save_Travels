package com.christopherrivera.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christopherrivera.savetravels.models.Expense;
import com.christopherrivera.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	//returns all the expenses
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	//creates or updates an expense
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	//retrieves an expense
	public Expense findExpense(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}
	
	//deletes an expense
	public void deleteExpense(Long id) {
		if(expenseRepository.findById(id).isPresent()) {
			expenseRepository.deleteById(id);
		}
	}
}
