package com.bitMiners.pdf.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// @Autowired
	// UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.GET)
	public String postLogin(String username, String password, Principal principal) {
//		System.out.println("================" + principal.getName());
		/*
		 * boolean isCorrect =
		 * userService.isCorrectUsernameAndPassword(username, password); if
		 * (isCorrect) {
		 * 
		 * return "redirect:/welcome"; } else { return "login"; }
		 */

		return "redirect:/welcome";
	}

}
