package com.bitMiners.pdf.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.service.QuestionService;
import com.bitMiners.pdf.service.UserService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/forum")
	public String questionList(Model model){
		model.addAttribute("questions",questionService.getAllQuestions());
		return "forum";
	}
	
	@RequestMapping("/wallPage")
	public String getWallPage(Model model){
		model.addAttribute("questions",questionService.getAllQuestions());
		return "wallPage";
	}
	
	@RequestMapping(value="/questions/add",method=RequestMethod.GET)
	public String addQuestion(){
		return "addQuestion";
	}
	
	@RequestMapping(value="/questions/addQuestion",method=RequestMethod.POST)
	public String addQuestion(Question question,/*Model model*/HttpSession session){
//		String currentUsername=(String)((ModelMap) model).get("currentUser");
		
		String currentUsername=(String) session.getAttribute("currentUser");
//		System.out.println("===================="+currentUsername);
		question.setUser(userService.getUserByUsername(currentUsername));
		
		question.setDateCreated(new Date());
		questionService.save(question);
		return "redirect:/forum";
	}

}
