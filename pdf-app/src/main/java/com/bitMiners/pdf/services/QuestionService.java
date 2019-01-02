package com.bitMiners.pdf.services;

import java.util.List;

import com.bitMiners.pdf.domain.Question;

public interface QuestionService {

	Integer save(Question question);
	List<Question> getAllQuestions();
	Question getQuestionById(int id);
	
	void deleteQuestionById(int id);
	void updateQuestion(Question question);
}
