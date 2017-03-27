package co.alexwilkinson.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout, String expire){
		
		if(error != null){
			model.addAttribute("error", "You entered incorrect details, please try again");
		}
		
		if(logout != null){
			model.addAttribute("message", "You have logged out successfully");
		}
		
		if(expire != null){
			model.addAttribute("message", "Session expired please login again");
		}
		
		return "login";
	}
	@PostMapping("/login")
	public String login(Model model, String error){
		
		if(error != null){
			model.addAttribute("error", "You entered incorrect details, please try again");
			
			return "login";
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
