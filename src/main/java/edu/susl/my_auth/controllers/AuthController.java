package edu.susl.my_auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.susl.my_auth.dto.UserRegistrationDto;
import edu.susl.my_auth.service.UserService;

@Controller
public class AuthController {
	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }	
	
	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		try {
			userService.registerNewUser(registrationDto);
			return "redirect:/login";
		} catch (Exception e) {
			return "redirect:/register?error";
		}
	}
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
}
