package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.Question;
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
        return questionRepository.findOne(id);
    }

    public void deleteQuestionById(int id) {
        questionRepository.delete(id);

    }

    public void updateQuestion(Question question) {
        questionRepository.update(question);
    }
}
