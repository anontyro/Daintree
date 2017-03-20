package co.alexwilkinson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.alexwilkinson.auth.service.SecurityService;
import co.alexwilkinson.auth.service.UserService;
import co.alexwilkinson.auth.validator.UserValidator;
import co.alexwilkinson.models.User;

@Controller
public class WebController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;

	@RequestMapping("/")
	public String index(Model model){
		
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("userForm", new User());
		return "register"; 
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
		userValidator.validate(userForm, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "register";
		}
		
		userService.save(userForm);
		
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
		
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public String login(Model model, String error, String logout){
		
		if(error != null){
			model.addAttribute("error", "You entered incorrect details, please try again");
		}
		
		if(logout != null){
			model.addAttribute("message", "You have logged out successfully");
		}
		
		return "login";
	}
	
}
