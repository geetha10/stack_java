package com.geetha.studentroster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geetha.studentroster.models.Dormitory;
import com.geetha.studentroster.models.Student;
import com.geetha.studentroster.service.AppService;

@Controller
public class AppController {
	
	@Autowired
	AppService appService;
	
	@GetMapping("/dashboard")
	public String dasboard(Model model) {
		List<Dormitory> dormitories=appService.getAllDorms();
		model.addAttribute("dormitories", dormitories);
		return "dashboard.jsp";
	}
	
	@GetMapping("/student/new")
	public String addStudent(@ModelAttribute("student") Student student) {
		return "addStudent.jsp";
	}
	
	@PostMapping("/student/new")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "addStudent.jsp";
		}else {
			appService.saveNewStudent(student);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/dormitory/new")
	public String addDormitory(@ModelAttribute("dormitory") Dormitory dormitory) {
		return "addDormitory.jsp";
	}
	
	@PostMapping("/dormitory/new")
	public String saveDormitory(@Valid @ModelAttribute("dormitory") Dormitory dormitory, BindingResult result) {
		if(result.hasErrors()) {
			return "addDormitory.jsp";
		}else {
			appService.createNewDormitory(dormitory);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/dormitory/{id}")
	public String addStudentsToDorm( @PathVariable("id") Long dormId, Model model) {
		List<Student> students=appService.findStudentWithoutDorm();
		model.addAttribute("students", students);
		Dormitory dorm= appService.getDormById(dormId);
		model.addAttribute("dorm", dorm);
		return "addStudentToDorm.jsp";
	}
	
	@PutMapping("/dormitory/{dormId}/addStudents")
	public String saveStudentsToDorm(
			@RequestParam("students") Long studentId, 
			@PathVariable("dormId") Long dormId) {
		
//			List<Student> students=appService.getAllStudents();
//			model.addAttribute("students", students);
//			return "addStudentToDorm.jsp";
	
			Student studentTobeAdded= appService.getStudentById(studentId);
			Dormitory dorm= appService.getDormById(dormId);
//			dorm.addStudent(studentTobeAdded);
			studentTobeAdded.setDormitory(dorm);
			appService.saveNewStudent(studentTobeAdded);
			return "redirect:/dormitory/"+String.valueOf(dormId);
		
	}
	
	@PutMapping("/removeStudent/dorm/{studentId}")
	public String removeStudentFromDorm(@PathVariable("studentId") Long studentId, @RequestParam("dormId") Long dormId) {
		Student student=appService.getStudentById(studentId);
		student.setDormitory(null);
		appService.saveNewStudent(student);
		return "redirect:/dormitory/"+String.valueOf(dormId);
	}
}
