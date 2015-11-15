package com.bitMiners.pdf.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/list")
	public String users(Model model){
		model.addAttribute("userList", userService.getAllUsers());
		return "allUsers";
	}
	
	@RequestMapping(value="/users/signupForm",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user){
		return "addUser";
	}
	
	@RequestMapping(value="/users/signup",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,Model model){
		System.out.println(user.getUserName());
		user.setDateCreated(new Date());
		userService.addUser(user);
		return "redirect:/users/list";
	}
	
}
