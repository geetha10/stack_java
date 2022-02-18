package com.example.mvcdemo.controllers;

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


import com.example.mvcdemo.models.Expense;
import com.example.mvcdemo.services.ExpenseService;

@Controller
public class AppController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses/dashboard")
	public String getAllExpenses(@ModelAttribute("expense") Expense expense, Model model){
		List<Expense> expenses = expenseService.getAllExpenses();
		model.addAttribute("expenses", expenses);
		return "Dashboard.jsp";
	}
	
//	@GetMapping("/expenses/new")
//	public String addExpense(@ModelAttribute("expense") Expense expense){
//		return "CreateNewExpense.jsp";
//	}
	
	@PostMapping("/expense/new")
	public String saveExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model){
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.getAllExpenses();
			model.addAttribute("expenses", expenses);
			return "Dashboard.jsp";
		} else {
			expenseService.saveExpense(expense);
			return "redirect:/expenses/dashboard";
		}
	}
	
	@GetMapping("/expense/edit/{id}")
	public String editExpense( @ModelAttribute("expense") Expense expense, Model model, @PathVariable("id") Long id) {
		Expense exp= expenseService.getExpenseByID(id);
		model.addAttribute("expense", exp);
		return "editExpense.jsp";
	}
	
	@PostMapping("/expense/update/{id}")
	public String updateExpense(@ModelAttribute("expense") Expense expense,  @PathVariable("id") Long id) {
		expense.setId(id);
		expenseService.saveExpense(expense);
		return "redirect:/expenses/dashboard";
	}
	
	@DeleteMapping("/expense/delete/{id}")
	public String deleteExpense(@PathVariable("id")Long id) {
		expenseService.deleteExpenseByID(id);
		return "redirect:/expenses/dashboard";
	}
	
}
