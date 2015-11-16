package com.bitMiners.pdf.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value="/questions/delete/{questionId}",method=RequestMethod.GET)
	public @ResponseBody Integer deleteQuestion(@PathVariable("questionId") int id){
		questionService.deleteQuestionById(id);
		return 1;
	}
	
	@RequestMapping(value="/questions/edit/{questionId}",method=RequestMethod.POST)
	public @ResponseBody Integer editQuestion(@RequestBody Question question,@PathVariable("questionId") int id){
		questionService.deleteQuestionById(id);
		return 1;
	}
}
