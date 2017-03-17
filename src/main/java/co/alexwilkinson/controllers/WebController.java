package co.alexwilkinson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/")
	public String index(Model model){
		
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		
		return "login";
	}
	
}
