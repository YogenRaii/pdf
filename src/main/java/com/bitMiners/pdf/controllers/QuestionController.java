package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.services.QuestionService;
import com.bitMiners.pdf.services.QuestionTypeService;
import com.bitMiners.pdf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionTypeService questionTypeService;

    @RequestMapping("/forum")
    public String questionList(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "forum";
    }

    @RequestMapping("/wallPage")
    public String getWallPage(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "wallPage";
    }

    @RequestMapping(value = "/questions/question/{id}", method = RequestMethod.GET)
    public String getQuestionDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("question", questionService.getQuestionById(id));
        return "questionDetails";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.GET)
    public String addQuestion(@ModelAttribute("question") Question question, Model model) {
        model.addAttribute("questionTypes", questionTypeService.getAllQuestionTypes());
        return "addQuestion";
    }

    @RequestMapping(value = "/questions/addQuestion", method = RequestMethod.POST)
    public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result,HttpSession session) {
        if (result.hasErrors()) {
            return "addQuestion";
        }

        String currentUsername = (String) session.getAttribute("currentUser");
        question.setUser(userService.getUserByUsername(currentUsername));

        question.setDateCreated(new Date());
        questionService.save(question);
        return "redirect:/wallPage";
    }

    @RequestMapping(value = "/questions/delete/{questionId}", method = RequestMethod.GET)
    public @ResponseBody Integer deleteQuestion(@PathVariable("questionId") int id) {
        questionService.deleteQuestionById(id);
        return 1;
    }

    @RequestMapping(value = "/questions/edit/{questionId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Integer editQuestion(@RequestBody Question question, @PathVariable("questionId") int id) {
        question.setId(id);
        questionService.updateQuestion(question);
        return 1;
    }
}
