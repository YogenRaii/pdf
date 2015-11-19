package com.bitMiners.pdf.controller;

import java.sql.ResultSet;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.service.ProfileService;
import com.bitMiners.pdf.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value={"/list",""})
	public String users(Model model){
		model.addAttribute("userList", userService.getAllUsers());
		return "allUsers";
	}
	
	@RequestMapping(value="/signupForm",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user,Model model){
		model.addAttribute("url", "signup");
		return "addUser";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult result){
		if(result.hasErrors()){
			return "addUser";
		}
		user.setProfile(new Profile());
		user.setDateCreated(new Date());
		//user.setRole("regular");
		user.setRole("general");
		userService.addUser(user);
		return "redirect:/users/list";
	}
	
	@RequestMapping(value="/addAdminForm",method=RequestMethod.GET)
	public String addAdmin(@ModelAttribute("user") User user,Model model){
		model.addAttribute("admin", "admin");
		model.addAttribute("url","addAdmin");
		return "addUser";
	}
	
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public String addAdmin(@ModelAttribute("user") User user){
		user.setProfile(new Profile());
		user.setDateCreated(new Date());
		user.setRole("admin");
		userService.addUser(user);
		return "redirect:/users/adminList";
	}
	
	@RequestMapping(value="/adminList",method=RequestMethod.GET)
	public String getAllAdmins(Model model){
		model.addAttribute("userList", userService.getAllAdmins());
		return "allUsers";
	}

	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Profile getUserProfile(@PathVariable("id") int id){
		Profile profile= profileService.getProfile(id);
		System.out.println(profile.getFirstName());
		return profile;
	}
	
}
