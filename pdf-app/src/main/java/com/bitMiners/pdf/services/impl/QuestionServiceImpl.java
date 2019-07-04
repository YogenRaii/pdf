package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.repositories.QuestionRepository;
import com.bitMiners.pdf.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Integer save(Question question) {
        return questionRepository.add(question);
    }

    public Question getQuestionById(int id) {
        Question question = questionRepository.findOne(id);
        if (question == null) {
            throw new PdfApiException("No question found with id: " + id, 404);
        }
        return question;
    }

    public void deleteQuestionById(int id) {
        Question question = questionRepository.findOne(id);
        if (question == null) {
            throw new PdfApiException("No question found with id: " + id, 404);
        }
        questionRepository.delete(id);

    }

    public Question updateQuestion(Question question) {
        return questionRepository.update(question);
    }
}
