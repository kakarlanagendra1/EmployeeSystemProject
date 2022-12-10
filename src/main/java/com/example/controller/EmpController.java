package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Employee;
import com.example.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "Add_Emp";
	}
	
	@GetMapping("/indexemp")
	public String index() {
		return "index";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		return "index";
	}
	

	@GetMapping("/display")
	public String display(Model m) {
		List<Employee> e = service.getAllEmp();
		m.addAttribute("emp", e);
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		return "redirect:/";
	}

	
}