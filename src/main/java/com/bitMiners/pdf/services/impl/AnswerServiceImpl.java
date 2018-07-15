package com.bitMiners.pdf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.repositories.AnswerRepository;
import com.bitMiners.pdf.services.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired 
	private AnswerRepository answerRepository;
	
	public Integer saveAnswer(Answer answer) {
		return answerRepository.add(answer);
	}

	public Integer updateAnswer(Answer answer) {
		return (answerRepository.update(answer))? 1:0;
	}

	public void deleteAnswer(int id) {
		answerRepository.delete(id);
		
	}

}
