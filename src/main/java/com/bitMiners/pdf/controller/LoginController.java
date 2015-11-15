package com.bitMiners.pdf.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bitMiners.pdf.service.UserService;

@SessionAttributes("currentUser")
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

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
	public String logout(Model model,SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String postLogin(String username, String password, Model model) {
//		 System.out.println("================" + principal.getName());

		boolean isCorrect = userService.isCorrectUsernameAndPassword(username, password);
		if (isCorrect) {
			model.addAttribute("currentUser", username);
			return "redirect:/welcome";
		}
		return "login";

		// return "redirect:/welcome";
	}

}
