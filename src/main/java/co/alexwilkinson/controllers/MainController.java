package co.alexwilkinson.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String index(){
		
		return "Basic message from Spring boot!";
		
	}

}
