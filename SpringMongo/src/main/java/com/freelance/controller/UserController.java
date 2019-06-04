package com.freelance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.freelance.model.User;
import com.freelance.services.UserDetailsServiceImpl;

@Controller
public class UserController {
	
	
	@Autowired
	UserDetailsServiceImpl userService;
	
	
	@GetMapping("/register")
	public String userForm(ModelMap map){
		User uservo = new User();
		map.addAttribute("uservo", uservo);
		return "register";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User uservo,ModelMap map){
		User userAdded = userService.userPropertiesSet(uservo);
		map.addAttribute("userrole", userAdded);
		return "success!";
	}
	
	
	@GetMapping("/admin")
	public String viewAdmin(@ModelAttribute User user,ModelMap map){
		map.addAttribute("adminguy", user);
		return "adminPage";
	}
	
	
	
	@GetMapping("/")
	public String homePage(){
		return "welcome";
	}
	
}
