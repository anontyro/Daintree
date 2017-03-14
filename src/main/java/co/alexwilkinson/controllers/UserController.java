package co.alexwilkinson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.alexwilkinson.models.User;

@Controller
public class UserController {

	@GetMapping("/userform")
	public String userForm(Model model){
		model.addAttribute("user", new User());
		return "userform";
	}
	
	@PostMapping("/userform")
	public String userSubmit(@ModelAttribute User user){
		return "userformresult";
	}
}
