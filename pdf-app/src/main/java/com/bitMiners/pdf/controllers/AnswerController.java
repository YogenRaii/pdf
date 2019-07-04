package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.exceptions.DataException;
import com.bitMiners.pdf.services.AnswerService;
import com.bitMiners.pdf.services.QuestionService;
import com.bitMiners.pdf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/users/{userId}/questions/{questionId}/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Integer> addAnswer(@Valid @RequestBody Answer answer, BindingResult result, @PathVariable("questionId") int questionId, @PathVariable("userId") int userId) {
        if (result.hasErrors()) {
            throw new DataException("Invalid Data!", result.getFieldErrors());
        }

        answer.setQuestion(questionService.getQuestionById(questionId));
        answer.setUser(userService.getUserById(userId));
        answer.setDateCreated(new Date());
        Integer createdId = answerService.saveAnswer(answer);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{answerId}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteAnswer(@PathVariable("answerId") int id, @PathVariable("questionId") int questionId, @PathVariable("userId") int userId) {
        answerService.deleteAnswer(id);
    }

    @RequestMapping(value = "/{answerId}", method = RequestMethod.PUT)
    public @ResponseBody Answer updateAnswer(@Valid @RequestBody Answer answer, BindingResult result, @PathVariable("answerId") int id, @PathVariable("questionId") int questionId, @PathVariable("userId") int userId) {
        if (result.hasErrors()) {
            throw new DataException("Invalid payload", result.getFieldErrors());
        }
        answer.setId(id);
        return answerService.updateAnswer(answer);
    }
}
