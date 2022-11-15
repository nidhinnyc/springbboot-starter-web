package com.starter.samplewebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.starter.samplewebapp.model.Employee;
import com.starter.samplewebapp.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private IEmployeeService service;

    //http://localhost:3011/employee/show
	@GetMapping("/show")
	public String show() {
		return "EmployeeRegister";
	}
	
	@PostMapping("/register")
	public String saveEmployee(@ModelAttribute Employee emp) {
		service.saveEmployee(emp);
		return "redirect:all";
	}
	
    //http://localhost:3011/employee/all
	@GetMapping("/all")
	public String showEmployees(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	//http://localhost:3011/employee/remove?id=2
	@GetMapping("/remove")
	public String removeEmployee(@RequestParam Integer id) {
		service.deleteEmployeeById(id);
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam Integer id,Model model) {
		Employee emp = service.getEmployeeById(id);
		model.addAttribute("emp", emp);
		return "EmployeeEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee emp) {
		service.updateEmployee(emp);
		return "redirect:all";
	}
}
