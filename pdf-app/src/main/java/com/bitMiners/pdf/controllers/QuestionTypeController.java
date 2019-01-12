package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.services.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/questionTypes")
public class QuestionTypeController {

    @Autowired
    private QuestionTypeService questionTypeService;

    @RequestMapping("")
    public String getAllQuestionTypes(Model model) {
        model.addAttribute("questionTypes", questionTypeService.getAllQuestionTypes());
        return "questionTypes";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addQuestionTypeForm(@ModelAttribute("questionType") QuestionType questionType) {
        return "addQuestionType";
    }

    @RequestMapping(value = "/addQuestionType", method = RequestMethod.POST)
    public String addQuestionType(@Valid @ModelAttribute("questionType") QuestionType questionType, BindingResult result) {
        if (result.hasErrors()) {
            return "addQuestionType";
        }
        questionTypeService.saveQuestionType(questionType);
        return "redirect:/questionTypes";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody Integer deleteQuestionType(@PathVariable("id") Long id) {
        questionTypeService.deleteQuestionType(id);
        return 1;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    public @ResponseBody Long editQuestionType(@RequestBody QuestionType questionType, @PathVariable("id") Long id) {
        questionType.setId(id);
        return questionTypeService.updateQuestionType(questionType);
    }
}
