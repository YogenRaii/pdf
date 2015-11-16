package com.bitMiners.pdf.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.service.AnswerService;
import com.bitMiners.pdf.service.QuestionService;
import com.bitMiners.pdf.service.UserService;

@Controller
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value="/answers/add/{questionId}/{userId}",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer addAnswer(@RequestBody  Answer answer,@PathVariable("questionId") int questionId,@PathVariable("userId") int userId){
//		System.out.println(answer.getAnswerContent());
//		Answer answer=new Answer();
//		answer.setAnswerContent(ans);
//		System.out.println("========="+userId);
		answer.setQuestion(questionService.getQuestionById(questionId));
		answer.setUser(userService.getUserById(userId));
		answer.setDateCreated(new Date());
		return answerService.saveAnswer(answer);
	}
	
	@RequestMapping(value="/answers/delete/{answerId}",method=RequestMethod.GET)
	public @ResponseBody Integer deleteAnswer(@PathVariable("answerId") int id){
		answerService.deleteAnswer(id);
		return 1;
	}
	
	@RequestMapping(value="/answers/edit/{answerId}",method=RequestMethod.POST)
	public @ResponseBody Integer updateAnswer(@RequestBody Answer answer,@PathVariable("answerId") int id){
		answer.setId(id);
		return answerService.updateAnswer(answer);
	}
}
