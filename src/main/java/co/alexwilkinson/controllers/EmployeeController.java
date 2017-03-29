package co.alexwilkinson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.alexwilkinson.models.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/form")
	public String employeeForm(Model model){
		model.addAttribute("employee", new Employee());
		
		return "employeeform";
	}

}
