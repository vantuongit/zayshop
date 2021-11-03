package edu.vinaenter.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.model.User;

@Controller
@RequestMapping("/auth")
public class ZayshopLoginController {
	
	@GetMapping("/login")
	public String login(ModelMap modelMap,@ModelAttribute("User") User user) {
		System.out.println(user.getUsername() + " v� "+ user.getPassword());
		return "login";
	}
}
