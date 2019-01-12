package com.bitMiners.pdf.services;

import com.bitMiners.pdf.domain.Question;

import java.util.List;

public interface QuestionService {

    Integer save(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(int id);

    void deleteQuestionById(int id);

    void updateQuestion(Question question);
}
