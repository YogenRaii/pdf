package com.bitMiners.pdf.service;

import java.util.List;

import com.bitMiners.pdf.domain.Question;

public interface QuestionService {

	Integer save(Question question);
	List<Question> getAllQuestions();
}
