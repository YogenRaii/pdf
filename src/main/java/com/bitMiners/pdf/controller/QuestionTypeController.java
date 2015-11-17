package com.bitMiners.pdf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.service.QuestionTypeService;

@Controller
public class QuestionTypeController {

	@Autowired
	private QuestionTypeService questionTypeService;
	
	@RequestMapping("/questionTypes")
	public String getAllQuestionTypes(Model model){
		model.addAttribute("questionTypes", questionTypeService.getAllQuestionTypes());
		return "questionTypes";
	}
	
	@RequestMapping(value="/questionTypes/add",method=RequestMethod.GET)
	public String addQuestionTypeForm(@ModelAttribute("questionType") QuestionType questionType){
		return "addQuestionType";
	}
	
	@RequestMapping(value="/questionTypes/addQuestionType",method=RequestMethod.POST)
	public String addQuestionType(@ModelAttribute("questionType") QuestionType questionType){
		questionTypeService.saveQuestionType(questionType);
		return "redirect:/questionTypes";
	}
}
