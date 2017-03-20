package co.alexwilkinson.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.net.SyslogOutputStream;
import co.alexwilkinson.models.User;
import co.alexwilkinson.models.UserDao;

@Controller
@RequestMapping("/users") //wrap all the user requests into the /user domain
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@GetMapping("/userform")
	public String userForm(Model model){
		model.addAttribute("user", new User());
		return "userform";
	}
	
	@PostMapping("/userform")
	public String userSubmit(@ModelAttribute User user){
		try{
			userDao.save(user);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return "userformresult";
	}
	
	//Controller to allow for the list of all users to be displayed
	@GetMapping("/list")
	public String listUsers(Model model){
		
		List<User> user = (List<User>) userDao.findAll();
		
		model.addAttribute("user", user);
		
		return "userlist";
	}
	
	@GetMapping("/updateuser")
	public String updateuser(@RequestParam("userId") long id, Model model){
		
		User user = userDao.findById(id);
		
		model.addAttribute("user", user);
		
		return "userform";
	}
	
	@GetMapping("/deleteuser")
	public String deleteuser(@RequestParam("userId") long id, Model model){
		
		userDao.delete(id);
		
		return "redirect:list";
	}
	
	
	
}
