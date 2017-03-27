package co.alexwilkinson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.alexwilkinson.auth.service.UserService;
import co.alexwilkinson.models.User;
import co.alexwilkinson.models.UserDao;

@Controller
@RequestMapping("/users") //wrap all the user requests into the /user domain
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	

//	@GetMapping("/userform")
//	public String userForm(Model model){
//		model.addAttribute("user", new User());
//		return "userform";
//	}
//	
	@PostMapping("/userform")
	public String userSubmit(@ModelAttribute User user){
		try{
			userService.save(user);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return "redirect:list?update";
	}
	
	//Controller to allow for the list of all users to be displayed
	@GetMapping("/list")
	public String listUsers(Model model, String update){
		
		List<User> user = (List<User>) userDao.findAll();
		
		if(update != null){
			model.addAttribute("message", "User successfully updated");
		}
		
		model.addAttribute("user", user);
		
		return "userlist";
	}
	
	@GetMapping("/updateuser")
	public String updateuser(@RequestParam("userId") long id, Model model){
		
		User user = userService.findById(id);
		
		model.addAttribute("user", user);
		
		return "userform";
	}
	
	@GetMapping("/deleteuser")
	public String deleteuser(@RequestParam("userId") long id, Model model){
		
		userDao.delete(id);
		
		return "redirect:list";
	}
	
	@GetMapping("/profile")
	public String viewprofile(Model model, Authentication auth){
		
		User user = userService.findByUsername(auth.getName()) ;
		
		model.addAttribute("user",user);
		
		return "userprofile";
	}
	
	
	
}
