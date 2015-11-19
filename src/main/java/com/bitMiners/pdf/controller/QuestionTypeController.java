package com.bitMiners.pdf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.service.QuestionTypeService;

@Controller
@RequestMapping("/questionTypes")
public class QuestionTypeController {

	@Autowired
	private QuestionTypeService questionTypeService;
	
	@RequestMapping("")
	public String getAllQuestionTypes(Model model){
		model.addAttribute("questionTypes", questionTypeService.getAllQuestionTypes());
		return "questionTypes";
	}
	
	@RequestMapping("/admin")
//	@PreAuthorize("hasRole('admin')")
	public String getAllQuestionTypesForAdmin(Model model){
		model.addAttribute("questionTypes", questionTypeService.getAllQuestionTypes());
		model.addAttribute("role", "admin");
		return "questionTypes";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addQuestionTypeForm(@ModelAttribute("questionType") QuestionType questionType){
		return "addQuestionType";
	}
	
	@RequestMapping(value="/addQuestionType",method=RequestMethod.POST)
	public String addQuestionType(@Valid @ModelAttribute("questionType") QuestionType questionType,BindingResult result){
		if(result.hasErrors()){
			return "addQuestionType";
		}
		questionTypeService.saveQuestionType(questionType);
		return "redirect:/questionTypes/admin";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public @ResponseBody Integer deleteQuestionType(@PathVariable("id") int id){
		questionTypeService.deleteQuestionType(id);
		return 1;
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.PATCH)
	public @ResponseBody Integer editQuestionType(@RequestBody QuestionType questionType, @PathVariable("id") int id){
		questionType.setId(id);
		return questionTypeService.updateQuestionType(questionType);
	}
}
