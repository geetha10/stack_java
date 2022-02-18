package com.example.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvcdemo.models.Expense;
import com.example.mvcdemo.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// private final ExpenseRepository expenseRepository;

	// public ExpenseService(ExpenseRepository expenseRepository) {
		// this.expenseRepository = expenseRepository;
	// }
	 
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public List<Expense> getAllExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expense getExpenseByID(Long id) {
		Optional<Expense> expense =expenseRepository.findById(id);
		return expense.get();
	}
	
	public void deleteExpenseByID(Long id) {
		expenseRepository.deleteById(id);
	}
	
}
