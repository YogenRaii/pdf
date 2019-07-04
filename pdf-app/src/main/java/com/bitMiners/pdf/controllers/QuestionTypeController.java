package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.exceptions.DataException;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.services.QuestionTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/questionTypes")
public class QuestionTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionTypeController.class);

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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteQuestionType(@PathVariable("id") Long id) {
        LOGGER.info("deleteQuestionType(): id -> {}", id);
        questionTypeService.deleteQuestionType(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody QuestionType editQuestionType(@RequestBody @Valid QuestionType questionType, BindingResult result, @PathVariable("id") Long id) {
        LOGGER.info("editQuestionType(): id -> {}", id);
        if (result.hasErrors()) {
            throw new DataException("Data Error!", result.getFieldErrors());
        }
        questionType.setId(id);
        return questionTypeService.updateQuestionType(questionType);
    }
}
