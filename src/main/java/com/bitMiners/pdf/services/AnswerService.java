package com.bitMiners.pdf.services;

import com.bitMiners.pdf.domain.Answer;

public interface AnswerService {

	Integer saveAnswer(Answer answer);
	
	Integer updateAnswer(Answer answer);
	
	void deleteAnswer(int id);
}
