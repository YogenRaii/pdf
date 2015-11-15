package com.bitMiners.pdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {
	@RequestMapping("/forum")
	public String questionList(Model model){
		return "forum";
	}

}
