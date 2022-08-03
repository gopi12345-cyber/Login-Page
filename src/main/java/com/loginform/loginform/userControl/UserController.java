package com.loginform.loginform.userControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginform.loginform.entity.User;
import com.loginform.loginform.repo.UserRepo;


@Controller
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String login(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "login";
	}
	@PostMapping("/userLogin")
	public String loginUsers(@ModelAttribute("user") User user) {
        String userId=user.getUserId();
		User userdata=userRepo.findByUserId(userId);
		if(user.getPassword().equals(userdata.getPassword())) {
		return "home";
		}
		else {
			return "error";
		}
	}

}
