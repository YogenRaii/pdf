package com.bitMiners.pdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping({"","/"})
	public String redirectRoot(){
		return "redirect:/user/list";
	}

	@RequestMapping("/user/list")
	public String users(){
		return "welcome";
	}
}
