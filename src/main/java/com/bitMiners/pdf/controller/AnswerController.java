package com.bitMiners.pdf.controller;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.service.AnswerService;
import com.bitMiners.pdf.service.QuestionService;
import com.bitMiners.pdf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/add/{questionId}/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Integer addAnswer(@Valid @RequestBody Answer answer, BindingResult result, @PathVariable("questionId") int questionId, @PathVariable("userId") int userId) {
        if (result.hasErrors()) {
            return -1;
        }

        answer.setQuestion(questionService.getQuestionById(questionId));
        answer.setUser(userService.getUserById(userId));
        answer.setDateCreated(new Date());
        return answerService.saveAnswer(answer);
    }

    @RequestMapping(value = "/delete/{answerId}", method = RequestMethod.GET)
    public @ResponseBody Integer deleteAnswer(@PathVariable("answerId") int id) {
        answerService.deleteAnswer(id);
        return 1;
    }

    @RequestMapping(value = "/edit/{answerId}", method = RequestMethod.POST)
    public @ResponseBody Integer updateAnswer(@RequestBody Answer answer, @PathVariable("answerId") int id) {
        answer.setId(id);
        return answerService.updateAnswer(answer);
    }
}
