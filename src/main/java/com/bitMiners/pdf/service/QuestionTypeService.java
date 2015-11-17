package com.bitMiners.pdf.service;

import java.util.List;

import com.bitMiners.pdf.domain.QuestionType;

public interface QuestionTypeService {

	Integer saveQuestionType(QuestionType questionType);
	
	Integer updateQuestionType(QuestionType questionType);
	
	void deleteQuestionType(int id);
	
	List<QuestionType> getAllQuestionTypes();
}
